package com.amihso;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Author cho1r
 * 2022/03/16 16:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-rabbitmq-producer.xml")
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * confirm 模式
     * 1. connectionFactory 中开启 publisher-confirms = "true"
     * 2. rabbitTemplate 中定义 ConfirmCallback回调函数
     */
    @Test
    public void testConfirm() {
        // 2. 定义回调
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                System.out.println("confirm called.");
                if (b) {
                    System.out.println("message received." + s);
                } else {
                    System.out.println("message receive failed." + s);
                }
            }
        });

        // 3. 发送消息
        rabbitTemplate.convertAndSend("test_exchange_confirm", "confirm", "message confirm.");

    }

    /**
     * 1. 开启return模式
     * 2. 设置 ReturnCallBack
     * 3. 设置Exchange处理消息的模式
     * 1. 丢弃(默认)
     * 2. 返回 Producer
     */
    @Test
    public void testReturn() {
        rabbitTemplate.setMandatory(true);

        // 2. 定义回调
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int i, String s, String s1, String s2) {
                System.out.println("return called.");
            }
        });

        // 3. 发送消息
        rabbitTemplate.convertAndSend("test_exchange_confirm11", "confirm11", "message confirm.");

    }

    @Test
    public void testSend() {
        for (int i = 0; i < 10; i++) {
            // 3. 发送消息
            rabbitTemplate.convertAndSend("test_exchange_confirm", "confirm", "message confirm.");
        }

    }

    @Test
    public void testTtl() {
//        for (int i = 0; i < 10; i++) {
//            // 3. 发送消息
//            rabbitTemplate.convertAndSend("test_exchange_ttl", "ttl.hah", "message ttl.");
//        }

        // 2. 消息单独过期

        // 消息后处理对象, 设置消息属性
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setExpiration("5000");
                return message;
            }
        };

        rabbitTemplate.convertAndSend("test_exchange_ttl", "ttl.hah", "message ttl.", messagePostProcessor);

    }

    /**
     * 测试死信
     * 1. 过期时间
     * 2. 队列长度
     * 3. 消息拒收
     */
    @Test
    public void testDlx() {
        // 1. 过期时间
        rabbitTemplate.convertAndSend("test_exchange_dlx", "test.dlx.haha", "message dlx.");

        // 2. 队列长度
//        for (int i = 0; i < 20; i++) {
//            rabbitTemplate.convertAndSend("test_exchange_dlx", "test.dlx.haha", "message dlx.");
//        }

        // 3. 消息拒收
        rabbitTemplate.convertAndSend("test_exchange_dlx", "test.dlx.haha", "message dlx.");
    }

    @Test
    public void testDelay() throws InterruptedException {
        // 1.
        rabbitTemplate.convertAndSend("order_exchange", "order.msg", "order info: id=1, time=11点55分.");

        // 倒计时
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            Thread.sleep(1000);
        }
    }
}
