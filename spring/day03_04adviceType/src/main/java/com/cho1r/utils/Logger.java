package com.cho1r.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Author cho1r
 * 2021/12/26 下午 03:19
 * 用于记录日志的工具类, 里面提供了公共的代码
 */
public class Logger {

    /**
     * 前置通知
     */
    public void beforePrintLog() {
        System.out.println("前置通知 beforePrintLog 已开始记录日志.");
    }

    /**
     * 后置通知
     */
    public void afterReturningPrintLog() {
        System.out.println("后置通知 afterReturningPrintLog 已开始记录日志.");
    }

    /**
     * 异常通知
     */
    public void afterThrowingPrintLog() {
        System.out.println("异常通知 afterThrowingPrintLog 已开始记录日志.");
    }

    /**
     * 最终通知
     */
    public void afterPrintLog() {
        System.out.println("最终通知 afterPrintLog 已开始记录日志.");
    }

    /**
     * 环绕通知
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object retVal = null;
        try {
            System.out.println("环绕通知 aroundPrintLog 已开始记录日志. 前置");
            retVal = pjp.proceed(pjp.getArgs());
            System.out.println("环绕通知 aroundPrintLog 已开始记录日志. 后置");
        } catch (Throwable e) {
            System.out.println("环绕通知 aroundPrintLog 已开始记录日志. 异常");
            e.printStackTrace();
        } finally {
            System.out.println("环绕通知 aroundPrintLog 已开始记录日志. 最终");
        }
        return retVal;
    }
}
