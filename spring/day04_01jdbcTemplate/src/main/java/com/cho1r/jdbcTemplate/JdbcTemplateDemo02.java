package com.cho1r.jdbcTemplate;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Author cho1r
 * 2021/12/27 下午 02:58
 */
public class JdbcTemplateDemo02 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);

        jdbcTemplate.execute("insert into account (name, money) values ('allen', 2400)");
    }
}
