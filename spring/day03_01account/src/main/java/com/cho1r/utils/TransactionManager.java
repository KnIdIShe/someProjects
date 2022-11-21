package com.cho1r.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * Author cho1r
 * 2021/12/24 下午 06:29
 * 事务相关的工具类, 包含开启事务, 提交事务, 回滚事务, 释放连接
 */
@Component("txManager")
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.cho1r.service.impl.*.*(..))")
    private void pt1() {
    }

    /**
     * 开启事务
     */
    public void startTransaction() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 提交事务
     */
    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */
    public void release() {
        try {
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) {
        try {
            startTransaction();
            Object retVal = pjp.proceed(pjp.getArgs());
            commit();
            return retVal;
        } catch (Throwable e) {
            e.printStackTrace();
            rollback();
        } finally {
            release();
        }
        return null;
    }

}
