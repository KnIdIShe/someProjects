package com.example.springbootconsumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Author cho1r
 * 2022/03/16 20:51
 */
@Component
public class RabbitMQListener {
    @RabbitListener(queues = "boot_queue")
    public void ListenerQueue(Message message) {
        System.out.println(message);
    }
}
