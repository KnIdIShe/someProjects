package com.cho1r.jdbc.myJdbc;

/**
 * Author cho1r
 * 2021-11-18 018 10:02 上午
 * 模拟JDBC接口
 */
public interface JdbcInterface {

    // close connection.
    public Object getConnection();

    // crud
    public void crud();

    // close
    public void close();

}
