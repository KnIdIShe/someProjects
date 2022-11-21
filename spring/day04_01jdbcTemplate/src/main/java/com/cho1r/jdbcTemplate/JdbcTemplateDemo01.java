package com.cho1r.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Author cho1r
 * 2021/12/27 下午 02:58
 */
public class JdbcTemplateDemo01 {
    public static void main(String[] args) {
        // 数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        // 创建 jdbcTemplate 对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        // 设置数据源
        jdbcTemplate.setDataSource(dataSource);

        jdbcTemplate.execute("insert into account (name, money) values ('mask', 2300)");
    }
}
