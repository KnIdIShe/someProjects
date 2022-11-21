package com.amihso;

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
public class Producer_WorkQueues {
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
        // 5. 创建队列queue
        // queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
        // queue name, 持久化, 独占(只一个消费者), 自动删除, 其他删除queue的参数
        channel.queueDeclare("WorkQueues", true, false, false, null);
        // 6. 发送消息
        // basicPublish(String exchange, String routingKey, BasicProperties props, byte[] body)
        // 交换机名称 default "", 路由名称 default queue name, 配置信息, 所发送数据
        for (int i = 1; i <= 10; i++) {
            byte[] body = ("hello, rabbitmq." + i).getBytes(StandardCharsets.UTF_8);
            channel.basicPublish("", "WorkQueues", null, body);
        }

        // 7. 释放资源
        channel.close();
        connection.close();
        factory.clone();

    }
}
