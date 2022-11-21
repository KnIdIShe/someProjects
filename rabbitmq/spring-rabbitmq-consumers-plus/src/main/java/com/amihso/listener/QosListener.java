package com.amihso.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * Author cho1r
 * 2022/03/17 20:46
 */

/**
 * consumer 限流机制
 * 1. ack 机制为 manual
 * 2. listener-container 配置属性 prefetch
 */
@Component
public class QosListener implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        // 1. 获取消息
        System.out.println(new String(message.getBody()));
        // 2. 处理业务逻辑
        // 3. 签收
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);

    }
}
