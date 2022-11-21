package com.yakumo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Springboot08SsmpApplication {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(args));
//        String[] arg = new String[1];
//        arg[0] = "--server.port=8082";
//        SpringApplication.run(Springboot08SsmpApplication.class, arg);

        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(Springboot08SsmpApplication.class);
    }

}
