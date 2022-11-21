package com.amihso;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * Author cho1r
 * 2022/03/14 10:36
 * 发送消息
 */
public class Producer_Routing {
    public static void main(String[] args) throws IOException, TimeoutException {

        // 1. 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 2. 设置参数
        factory.setHost("192.168.55.105"); // ip default localhost
        factory.setPort(5672); // port default 5672
        factory.setVirtualHost("/tom"); // 虚拟机 default /
        factory.setUsername("tom"); // username default guest
        factory.setPassword("tom"); // password default guest
        // 3. 创建连接connection
        Connection connection = factory.newConnection();
        // 4. 创建channel
        Channel channel = connection.createChannel();
        // 5. 创建交换机
        String exchangeName = "test_direct";
        // exchangeDeclare(String exchange, BuiltinExchangeType type, boolean durable, boolean autoDelete, boolean internal, Map<String, Object> arguments)
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.DIRECT, true, false, false, null);
        // 6. 创建队列queue
        String queueName01 = "test_direct_queue01";
        String queueName02 = "test_direct_queue02";
        channel.queueDeclare(queueName01, true, false, false, null);
        channel.queueDeclare(queueName02, true, false, false, null);
        // 7. 绑定交换机和队列
        // queue 01, error
        channel.queueBind(queueName01, exchangeName, "error");
        // queue 02, info, warning, error
        channel.queueBind(queueName02, exchangeName, "info");
        channel.queueBind(queueName02, exchangeName, "warning");
        channel.queueBind(queueName02, exchangeName, "error");
        // 8. 发送消息
//        String body = "tom called getAll()... log level: info...";
//        channel.basicPublish(exchangeName, "info", null, body.getBytes(StandardCharsets.UTF_8));

        String body = "tom called delete() failed... log level: error...";
        channel.basicPublish(exchangeName, "error", null, body.getBytes(StandardCharsets.UTF_8));
        // 9. 释放资源
        channel.close();
        connection.close();
        factory.clone();

    }
}
