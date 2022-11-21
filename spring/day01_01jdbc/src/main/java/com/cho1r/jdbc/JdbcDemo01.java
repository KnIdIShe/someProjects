package com.cho1r.jdbc;

import java.sql.*;

/**
 * Author cho1r
 * 2021/12/19 下午 05:34
 * 程序的耦合: 程序间的依赖关系(类, 方法...)
 * 开发中: 做到编译器不依赖, 运行期才依赖
 *
 */
public class JdbcDemo01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 注册驱动
        // 若缺少 jar 包, 程序将无法运行, 此为程序的耦合
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        // 通过反射, 字符串不影响编译期, 可通过配置文件使之更加灵活
//        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        // 获取预处理对象
        PreparedStatement preparedStatement = connection.prepareStatement("select * from account");
        // 执行sql, 得到结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        // 遍历结果集
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
        // 释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();

    }
}
