package com.amihso.rabbitmq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * Author cho1r
 * 2022/03/16 16:26
 */
public class SpringQueueListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        // 打印消息
        System.out.println(new String(message.getBody()));
    }
}
