package com.cho1r.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Author cho1r
 * 2021/12/23 下午 07:05
 */
@Aspect
@Component
public class LoggingAspect {
    // 在执行UserService的每个方法前执行:
//    @Before("execution(public * com.cho1r.service.UserService.*(..))")
    @Before("execution(public * com..*.UserService.*(..))")
    public void doAccessCheck() {
        System.err.println("[Before] do access check...");
    }

}
