package com.cho1r.dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Author cho1r
 * 2021/12/28 下午 02:52
 */
public class JdbcDaoSupport {
    public JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
