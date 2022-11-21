package com.cho1r.dao.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Author cho1r
 * 2021-11-22 022 02:03 下午
 */
public class JDBCUtilsBydruid {
    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src\\druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void close(ResultSet rs, Statement statement, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();// 释放引用, 不是关闭socket连接
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
