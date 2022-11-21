package com.cho1r.jdbc.myJdbc;

/**
 * Author cho1r
 * 2021-11-18 018 10:08 上午
 */
public class TestJdbc {
    public static void main(String[] args) {

        // operate MySQL
//        JdbcInterface jdbc = new MysqlJdbcImpl();

        // operate Oracle
        JdbcInterface jdbc = new OracleJdbcImpl();

        jdbc.getConnection();
        jdbc.crud();
        jdbc.close();
    }
}
