package com.cho1r.jdbc.dataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author cho1r
 * 2021-11-22 022 08:56 下午
 */
public class resultSet2ArrayListByDBUtils {
    public static void main(String[] args) throws Exception {

        Connection connection = JDBCUtilsBydruid.getConnection();

        QueryRunner queryRunner = new QueryRunner();

        String sql = "select * from actor;";

        // 多行
        List<Actor> list = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class));

        list.forEach(System.out::println);

        JDBCUtilsBydruid.close(null, null, connection);
    }

    @Test
    public void DBUtilsQuerySingle() throws SQLException {
        Connection connection = JDBCUtilsBydruid.getConnection();

        QueryRunner queryRunner = new QueryRunner();

        String sql = "select * from actor where id = ?;";

        // 单行
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 1);
        System.out.println(actor);

        JDBCUtilsBydruid.close(null, null, connection);
    }

    @Test
    public void DBUtilsQueryScalar() throws SQLException {
        Connection connection = JDBCUtilsBydruid.getConnection();

        QueryRunner queryRunner = new QueryRunner();

        String sql = "select name from actor where id = ?;";

        // 单行单列
        String name = queryRunner.query(connection, sql, new ScalarHandler<String>(), 1);
        System.out.println(name);

        JDBCUtilsBydruid.close(null, null, connection);
    }

    @Test
    public void DBUtilsDML() throws SQLException {
        Connection connection = JDBCUtilsBydruid.getConnection();

        QueryRunner queryRunner = new QueryRunner();

//        String sql = "update actor set name = ? where id = ?";
//        String sql = "insert into actor values (null, ?, ?, ?, ?)";
        String sql = "delete from actor where id = ?";
//        int affectedRows = queryRunner.update(connection, sql, "alice", "F", "2002-02-03", "116");
        int affectedRows = queryRunner.update(connection, sql, 3);
        System.out.println(affectedRows);

        JDBCUtilsBydruid.close(null, null, connection);
    }
}
