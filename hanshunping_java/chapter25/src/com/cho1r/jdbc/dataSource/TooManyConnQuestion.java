package com.cho1r.jdbc.dataSource;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Author cho1r
 * 2021-11-22 022 08:37 上午
 */
public class TooManyConnQuestion {

    @Test
    public void testManyConn() throws Exception {

        Properties properties = new Properties();
        properties.load(new FileReader("src/mysql.properties"));
        String user = properties.getProperty("user", "root");
        String pwd = properties.getProperty("password", "root");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        Class.forName(driver);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = DriverManager.getConnection(url, user, pwd);
            connection.close();
        }
        System.out.println(System.currentTimeMillis() - start);// 96084, 97890
    }
}
