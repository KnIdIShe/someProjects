package com.cho1r.jdbc.dataSource;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Author cho1r
 * 2021-11-22 022 08:56 下午
 */
public class resultSet2ArrayList {
    public static void main(String[] args) throws Exception {

        Connection connection = JDBCUtilsBydruid.getConnection();
        System.out.println(connection.getClass());

        Statement statement = connection.createStatement();

        String sql = "select * from actor";

        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Actor> list = new ArrayList<Actor>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
//            String borndate = resultSet.getString("borndate");
            Date borndate = resultSet.getDate("borndate");
            String phone = resultSet.getString("phone");

            list.add(new Actor(id, name, sex, borndate, phone));
//            System.out.println(id + ", " + name + ", " + sex + ", " + borndate + ", " + phone);
        }

        list.forEach(System.out::println);

        JDBCUtilsBydruid.close(resultSet, statement, connection);
    }
}
