package com.cho1r;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot13ConfigurationApplicationTests {

    @Value("${servers.ipAddress}")
    private String ip;

    @Value("${datasource.password}")
    private String pwd;

    @Test
    void contextLoads() {
        System.out.println(ip);
        System.out.println(pwd);
    }

}
