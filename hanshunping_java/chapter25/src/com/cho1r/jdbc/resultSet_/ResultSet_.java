package com.cho1r.jdbc.resultSet_;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Author cho1r
 * 2021-11-19 019 08:42 上午
 */
public class ResultSet_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        Properties properties = new Properties();
        properties.load(new FileReader("src/mysql.properties"));

        String user = properties.getProperty("user", "root");
        String pwd = properties.getProperty("password", "root");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, pwd);

        Statement statement = connection.createStatement();

        String sql = "select * from test.actor";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
//            String borndate = resultSet.getString("borndate");
            Date borndate = resultSet.getDate("borndate");
            String phone = resultSet.getString("phone");

            System.out.println(id + ", " + name + ", " + sex + ", " + borndate + ", " + phone);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
