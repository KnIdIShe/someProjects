package com.yakumo.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author cho1r
 * 2022/03/16 19:51
 */
@Configuration
public class RabbitMQConfig {
    public static final String EXCHANGE_NAME = "boot_topic_exchange";
    public static final String QUEUE_NAME = "boot_queue";

    // 1. exchanges
    @Bean("bootExchange")
    public Exchange BootExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }

    // queues
    @Bean("bootQueue")
    public Queue BootQueue() {
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    // bindings
    @Bean
    public Binding BindQueueExchange(@Qualifier("bootQueue") Queue queue, @Qualifier("bootExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("boot.#").noargs();
    }
}
