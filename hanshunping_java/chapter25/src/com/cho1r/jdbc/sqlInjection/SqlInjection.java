package com.cho1r.jdbc.sqlInjection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Author cho1r
 * 2021-11-19 019 06:03 下午
 */
public class SqlInjection {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/test";
        String name = "";
        String pwd = "' or '1' = '1";


        Connection connection = DriverManager.getConnection(url, "root", "root");

        Statement statement = connection.createStatement();

        String sql = "select * from users where name = '" + name + "' and pwd = '" + pwd + "';";

        System.out.println(sql);
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            System.out.println("ok");
        } else {
            System.out.println("failed.");
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
