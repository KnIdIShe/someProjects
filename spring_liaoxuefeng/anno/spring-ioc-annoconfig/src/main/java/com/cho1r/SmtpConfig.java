package com.cho1r;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Author cho1r
 * 2021/12/23 下午 04:37
 */
@Component
public class SmtpConfig {
    @Value("${host}")
    public String host;
    @Value("${port}")
    public String port;

//    public String getHost() {
//        return host;
//    }
//
//    public String getPort() {
//        return port;
//    }
}
