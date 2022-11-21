package com.cho1r.jdbcTemplate;

import com.cho1r.dao.IAccountDao;
import com.cho1r.dao.JdbcDaoSupport;
import com.cho1r.dao.impl.AccountDaoImpl;
import com.cho1r.domain.Account;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Author cho1r
 * 2021/12/27 下午 02:58
 */
public class JdbcTemplateDemo04 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = applicationContext.getBean("accountDao", IAccountDao.class);

        Account account = accountDao.findAccountById(2);

        System.out.println(account);

//        account.setMoney(10000);
//        accountDao.updateAccount(account);
    }
}
