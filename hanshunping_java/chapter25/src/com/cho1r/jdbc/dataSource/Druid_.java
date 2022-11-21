package com.cho1r.jdbc.dataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * Author cho1r
 * 2021-11-22 022 01:44 下午
 */
public class Druid_ {

    @Test
    public void test_druid() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 500000; i++) {
            Connection connection = dataSource.getConnection();
//            System.out.println("connection succeeded.");
            connection.close();
        }
        System.out.println(System.currentTimeMillis() - start);// 96084, 973, 1132

    }
}
