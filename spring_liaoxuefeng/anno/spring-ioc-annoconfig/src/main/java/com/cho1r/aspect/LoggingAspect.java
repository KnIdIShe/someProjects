package com.cho1r.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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
    @Before("execution(public * com.cho1r.service.UserService.*(..))")
    public void doAccessCheck() {
        System.err.println("[Before] do access check...");
    }

    // 在执行MailService的每个方法前后执行:
    @Around("execution(public * com.cho1r.service.MailService.*(..))")
    public Object Logging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.err.println("[Around] start " + proceedingJoinPoint.getSignature());
        Object retVal = proceedingJoinPoint.proceed();
        System.err.println("[Around] done " + proceedingJoinPoint.getSignature());
        return retVal;
    }
}
