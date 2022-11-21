package com.cho1r.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class MailService {
    @Autowired
    UserService userService;

    public String sendMail() {
        // Spring通过CGLIB动态创建的UserService$$EnhancerBySpringCGLIB代理类，
        // 它的构造方法中，并未调用super()，因此，从父类继承的成员变量，包括final类型的成员变量，统统都没有初始化。
//        ZoneId zoneId = userService.zoneId; // NullPointException
        ZoneId zoneId = userService.getZoneId();
        String dt = ZonedDateTime.now(zoneId).toString();
        return "Hello, it is " + dt;
    }
}
