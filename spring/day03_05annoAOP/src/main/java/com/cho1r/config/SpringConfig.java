package com.cho1r.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Author cho1r
 * 2021/12/26 下午 07:18
 */
@Configuration
@ComponentScan(basePackages = "com.cho1r")
@EnableAspectJAutoProxy
public class SpringConfig {
}
