package com.cho1r.aspect.runtime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Author cho1r
 * 2021/12/27 下午 07:04
 */
@Aspect
@Component
public class RunTimeAspect {
    @Around("@annotation(runTime)")
    public Object runTime(ProceedingJoinPoint pjp, RunTime runTime) {
        String name = runTime.value();
        long start = System.currentTimeMillis();
        try {
            return pjp.proceed(pjp.getArgs());
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            long end = System.currentTimeMillis();
            System.err.println("runtime: " + name + (end - start) + "ms");
        }
        return null;
    }
}
