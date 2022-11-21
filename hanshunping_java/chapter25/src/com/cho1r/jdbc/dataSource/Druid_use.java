package com.cho1r.jdbc.dataSource;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

/**
 * Author cho1r
 * 2021-11-22 022 08:56 下午
 */
public class Druid_use {
    public static void main(String[] args) throws Exception {

        Connection connection = JDBCUtilsBydruid.getConnection();
        System.out.println(connection.getClass());

        Statement statement = connection.createStatement();

        String sql = "select * from actor";

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

        JDBCUtilsBydruid.close(resultSet, statement, connection);
    }
}
