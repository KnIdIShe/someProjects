package com.cho1r.utils;

import java.sql.SQLException;

/**
 * Author cho1r
 * 2021/12/24 下午 06:29
 * 事务相关的工具类, 包含开启事务, 提交事务, 回滚事务, 释放连接
 */
public class TransactionManager {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public void startTransaction() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
            System.out.println("已成功进入aop.");
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

}
