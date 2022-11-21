package com.amihso.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Author cho1r
 * 2022/03/17 20:46
 */

/**
 * consumer ack机制
 * 1. 设置手动签收: acknowledge="manual"
 * 2. 监听器实现 ChannelAwareMessageListener
 * 3. 消息处理成功 ,调用 channel.basicAck()手动签收
 * 4. 消息处理失败, 调用 channel.basicNack()拒收, broker至重新发送consumer
 */
@Component
public class AckListener implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        Thread.sleep(1000);
        long deliveryTag = message.getMessageProperties().getDeliveryTag();

        try {
            // 1. 接收消息
            System.out.println(new String(message.getBody()));
            // 2. 处理业务逻辑
            System.out.println("do something.");
            // 模拟异常
            int i = 1 / 0;
            // 3. 手动签收
            channel.basicAck(deliveryTag, true);
        } catch (Exception e) {
//            e.printStackTrace();
            channel.basicNack(deliveryTag, true, true);
//            channel.basicReject(deliveryTag, true); // deliveryTag, requeue
        }
    }
}
