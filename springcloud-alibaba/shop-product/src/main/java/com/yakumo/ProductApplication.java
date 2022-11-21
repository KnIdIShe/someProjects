package com.yakumo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


/**
 * Author cho1r
 * 2022/03/21 11:14
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class}, scanBasePackages = "com")
//@SpringBootApplication(scanBasePackages = "com.yakumo")
@EntityScan("com.yakumo.domain")
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class);
    }
}
