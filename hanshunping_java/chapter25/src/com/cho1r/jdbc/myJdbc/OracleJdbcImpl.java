package com.cho1r.jdbc.myJdbc;

/**
 * Author cho1r
 * 2021-11-18 018 10:04 上午
 * 模拟 Oracle 驱动, 实现jdbc接口
 */
public class OracleJdbcImpl implements JdbcInterface {

    @Override
    public Object getConnection() {
        System.out.println("get Oracle connection.");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("Oracle crud.");
    }

    @Override
    public void close() {
        System.out.println("close Oracle connection.");
    }
}
