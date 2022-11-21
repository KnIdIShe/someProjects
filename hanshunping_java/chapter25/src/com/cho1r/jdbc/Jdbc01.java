package com.cho1r.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Author cho1r
 * 2021-11-18 018 10:39 上午
 */
public class Jdbc01 {
    public static void main(String[] args) throws SQLException {

        // 1. 注册驱动
        Driver driver = new Driver();
        // 2. 获取连接
        String url = "jdbc:mysql://localhost:3306/test";

        // 用户名和密码放入 properties 对象
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");

        Connection connect = driver.connect(url, properties);
        // 3. 执行操作(crud)
        String sql = "INSERT INTO actor VALUES (NULL, 'tom', 'M', '2012-01-03', '13802340567');";

        // 执行静态sql, 并获取返回的结果  的对象
        Statement statement = connect.createStatement();
        // 受影响的行数
        int rows = statement.executeUpdate(sql);

        System.out.println(rows == 1 ? "ok" : "oops...");
        // 4. 关闭连接
        statement.close();
        connect.close();
    }
}
