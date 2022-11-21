package com.cho1r.dao.dao;

import com.cho1r.jdbc.dataSource.JDBCUtilsBydruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Author cho1r
 * 2021-11-24 024 12:13 下午
 */
public class BasicDao<T> {
    private QueryRunner queryRunner = new QueryRunner();

    // dml
    public int update(String sql, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsBydruid.getConnection();
            int rows = queryRunner.update(connection, sql, parameters);
            return rows;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsBydruid.close(null, null, connection);
        }
    }

    // 查询多行
    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsBydruid.getConnection();
            return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsBydruid.close(null, null, connection);
        }
    }

    // 查询单行
    public T querySingle(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsBydruid.getConnection();
            return queryRunner.query(connection, sql, new BeanHandler<T>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsBydruid.close(null, null, connection);
        }
    }

    // 查询单行单列(即单值)
    public Object queryScalar(String sql, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsBydruid.getConnection();
            return queryRunner.query(connection, sql, new ScalarHandler<>(), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsBydruid.close(null, null, connection);
        }
    }
}
