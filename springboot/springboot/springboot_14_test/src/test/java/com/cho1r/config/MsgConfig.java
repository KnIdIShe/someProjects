package com.cho1r.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author cho1r
 * 16/2/2022 下午6:49
 */
@Configuration
public class MsgConfig {

    @Bean
    public String msg() {
        return "msg bean";
    }
}
