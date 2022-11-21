package com.amihso;

import org.junit.Test;
import org.junit.runner.RunWith;
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

    // 1. 注入 RabbitTemplate
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testHelloWorld() {
        // 2. 发送消息
        rabbitTemplate.convertSendAndReceive("spring_queue", "hello world, spring...");
    }

    @Test
    public void testFanout() {
        // 2. 发送 fanout 消息
        rabbitTemplate.convertSendAndReceive("spring_fanout_exchange", "", "spring fanout...");
    }

    @Test
    public void testTopic() {
        // 2. 发送 topic 消息
        rabbitTemplate.convertSendAndReceive("spring_topic_exchange", "heima.hehe.haha", "spring topic...");
//        rabbitTemplate.convertSendAndReceive("spring_topic_exchange", "", "spring fanout...");
//        rabbitTemplate.convertSendAndReceive("spring_topic_exchange", "", "spring fanout...");
    }
}
