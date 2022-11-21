package com.cho1r.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * Author cho1r
 * 2021/12/24 上午 10:27
 */
//@Configuration
//@ComponentScan(basePackages = {"com.cho1r"})
//@ComponentScan(value = {"com.cho1r"})
//@ComponentScan({"com.cho1r"})
//@ComponentScan("com.cho1r")
@Import(JdbcConfig.class)
//@Component
public class SpringConfig {


}
