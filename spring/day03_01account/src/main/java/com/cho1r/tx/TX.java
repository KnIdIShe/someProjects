package com.cho1r.tx;

import com.cho1r.utils.TransactionManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author cho1r
 * 2021/12/26 下午 07:45
 */
//@Component
//@Aspect
public class TX {

    @Autowired
    private TransactionManager transactionManager;


    @Pointcut("execution(* com.cho1r.service.impl.*.*(..))")
    private void pt1() {
    }

    @Around("pt1()")
    public Object addTX(ProceedingJoinPoint pjp) {
        Object retVal = null;
        try {
            System.out.println("已成功进入aop.");
            // 开启事务
            transactionManager.startTransaction();
            // 执行操作
            retVal = pjp.proceed(pjp.getArgs());
            // 提交事务
            transactionManager.commit();
            // 返回结果
            return retVal;
        } catch (Throwable throwable) {
            // 回滚事务
            transactionManager.rollback();
            throwable.printStackTrace();
        } finally {
            transactionManager.release();
        }
        return retVal;
    }
}
