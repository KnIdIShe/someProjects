package com.cho1r.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Author cho1r
 * 2021-11-18 018 08:00 下午
 */
public class Homework01 {
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
        ArrayList<String> list = new ArrayList<>();
        list.add("use test;");
        list.add("create table news (id int, content varchar(32));");
        list.add("insert into news values (1, 'tom');");
        list.add("insert into news values (2, 'jerry');");
        list.add("insert into news values (3, 'iris');");
        list.add("update news set content = 'alice' where id = 1;");
        list.add("delete from news where id = 2;");

        for (String s : list) {
            System.out.println(statement.executeUpdate(s));
        }

//        System.out.println(rows);
        statement.close();
        connection.close();
    }
}
