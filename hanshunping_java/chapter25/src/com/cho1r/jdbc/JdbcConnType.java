package com.cho1r.jdbc;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Author cho1r
 * 2021-11-18 018 07:21 下午
 */
public class JdbcConnType {
    public static void main(String[] args) {

    }

    @Test
    // 使用反射, 动态加载, 减少依赖
    public void connType02() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/test";

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");

        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    @Test
    // 使用 DriverManager 统一管理 Driver
    public void connType03() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/test";

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");

        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url, properties);

        System.out.println(connection);
    }

    @Test
    // 反射, 底层 static{} 自动注册 Driver
    // 常用, 推荐
    public void connType04() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/test";

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");

        Connection connection = DriverManager.getConnection(url, properties);

        System.out.println(connection);
        connection.close();
    }

    @Test
    // 反射, 底层 static{} 自动注册 Driver
    // 使用配置文件
    public void connType05() throws ClassNotFoundException, SQLException, IOException {

        Properties properties = new Properties();
        properties.load(new FileReader("src/mysql.properties"));
        String user = properties.getProperty("user", "root");
        String pwd = properties.getProperty("password", "root");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, pwd);

        System.out.println(connection);
        connection.close();
    }
}
