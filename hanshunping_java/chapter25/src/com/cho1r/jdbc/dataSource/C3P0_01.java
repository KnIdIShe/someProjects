package com.cho1r.jdbc.dataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Author cho1r
 * 2021-11-22 022 10:49 上午
 */
public class C3P0_01 {

    @Test
    public void test_C3P0_01() throws Exception {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        Properties properties = new Properties();
        properties.load(new FileReader("src/mysql.properties"));
        String user = properties.getProperty("user", "root");
        String pwd = properties.getProperty("password", "root");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        // 设置相关参数
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(pwd);

        // 初始连接数
        comboPooledDataSource.setInitialPoolSize(10);
        // 最大连接数
        comboPooledDataSource.setMaxPoolSize(50);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 500000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
//          System.out.println("connection succeeded.");
            connection.close();
        }
        System.out.println(System.currentTimeMillis() - start);// 96084, 750, 2476
    }

    @Test
    public void test_C3P0_02() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("C3P0");
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println("connection succeeded.");
        System.out.println(connection.getClass());
        connection.close();
    }
}
