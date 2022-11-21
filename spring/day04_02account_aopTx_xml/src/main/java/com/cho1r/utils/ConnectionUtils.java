package com.cho1r.utils;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Author cho1r
 * 2021/12/24 下午 06:17
 * 从数据源中获取连接并与线程绑定
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的 connection
     * @return
     */
    public Connection getThreadConnection() {
        // 从ThreadLocal中获取
        Connection connection = threadLocal.get();
        // 判断是否为空
        if (connection == null) {
            // 从数据源获取连接, 并存入 ThreadLocal
            try {
                connection = dataSource.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            threadLocal.set(connection);
        }
        return connection;
    }

    /**
     * 将连接与线程解绑
     */
    public void removeConnection() {
        threadLocal.remove();
    }
}
