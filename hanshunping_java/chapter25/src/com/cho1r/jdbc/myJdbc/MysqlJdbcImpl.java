package com.cho1r.jdbc.myJdbc;

/**
 * Author cho1r
 * 2021-11-18 018 10:04 上午
 * 模拟 MySQL 驱动, 实现jdbc接口
 */
public class MysqlJdbcImpl implements JdbcInterface {

    @Override
    public Object getConnection() {
        System.out.println("get MySQL connection.");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("MySQL crud.");
    }

    @Override
    public void close() {
        System.out.println("close MySQL connection.");
    }
}
