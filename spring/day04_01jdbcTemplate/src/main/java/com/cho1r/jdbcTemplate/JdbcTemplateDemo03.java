package com.cho1r.jdbcTemplate;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.*;

/**
 * Author cho1r
 * 2021/12/27 下午 02:58
 */
public class JdbcTemplateDemo03 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);

        // 保存
//        jdbcTemplate.update("insert into account (name, money) values (?, ?)", "alice", 1400);

        // 更新
//        jdbcTemplate.update("update account set name = ?, money = ? where id = ?", "test", 1000, 2);

        // 删除
//        jdbcTemplate.update("delete from account where id = ?", 3);

        // 查询所有
//        List<Account> accounts = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<>(Account.class));


//        List<Account> accounts = jdbcTemplate.query("select * from account", new RowMapper<Account>() {
//            @Override
//            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
//                Account account = new Account();
//
//                account.setId(resultSet.getLong("id"));
//                account.setName(resultSet.getString("name"));
//                account.setMoney(resultSet.getDouble("money"));
//
//                return account;
//            }
//        });

//        for (Account account : accounts) {
//            System.out.println(account);
//        }

        // 查询单个
//        List<Account> accounts = jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<>(Account.class), 67);
//        System.out.println(accounts.isEmpty() ? "无结果" : accounts.get(0));


        // 查询单行单列, 例如 count(*)
        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(count);

    }
}
