package com.cho1r.jdbc.batch_;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * Author cho1r
 * 2021-11-21 021 12:30 下午
 */
public class Batch_ {

    @Test
    public void noBatch() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("src/mysql.properties"));
        String user = properties.getProperty("user", "root");
        String pwd = properties.getProperty("password", "root");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, pwd);

        String sql = "insert into users values (null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "tom" + i);
            preparedStatement.setString(2, "tom" + i);
            preparedStatement.executeUpdate();
        }
        System.out.println(System.currentTimeMillis() - start); // 3921

        preparedStatement.close();
        connection.close();
    }

    @Test
    public void batch() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("src/mysql.properties"));
        String user = properties.getProperty("user", "root");
        String pwd = properties.getProperty("password", "root");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, pwd);

        String sql = "insert into users values (null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "tom" + i);
            preparedStatement.setString(2, "tom" + i);
            preparedStatement.addBatch();

            if ((i + 1) % 1000 == 0) {
                preparedStatement.executeBatch();// 在 finally {} 中会调用 clearBatch()
                preparedStatement.clearBatch();
            }

        }
        System.out.println(System.currentTimeMillis() - start); // 3921, 118, 103

        preparedStatement.close();
        connection.close();
    }

}
