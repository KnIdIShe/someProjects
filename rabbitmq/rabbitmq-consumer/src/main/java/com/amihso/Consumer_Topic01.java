package com.amihso;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Author cho1r
 * 2022/03/14 10:36
 * 接收消息
 */
public class Consumer_Topic01 {
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
//        channel.queueDeclare("WorkQueues", true, false, false, null);
        // 6. 接收消息
        // basicConsume(String queue, boolean autoAck, Consumer callback)
        // queue name, 自动回执, 回调函数

        String queueName01 = "test_topic_queue01";
        String queueName02 = "test_topic_queue02";

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                System.out.println("consumerTag: " + consumerTag);
//                System.out.println("Exchange: " + envelope.getExchange());
//                System.out.println("RoutingKey: " + envelope.getRoutingKey());
//                System.out.println("properties: " + properties);
                System.out.println("body: " + new String(body));
                System.out.println("save log to db.");
            }
        };
        channel.basicConsume(queueName01, true, consumer);

        // 7. 不需要释放资源, 持续监听
//        channel.close();
//        connection.close();
//        factory.clone();

    }
}
