package com.cho1r.dao.impl;

import com.cho1r.dao.IAccountDao;
import com.cho1r.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

/**
 * Author cho1r
 * 2021/12/28 下午 01:19
 * 账户的持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void init() {
        super.setDataSource(dataSource);
    }

    @Override
    public Account findAccountById(long id) {
        List<Account> accounts = getJdbcTemplate().query("select * from account where id = ?", new BeanPropertyRowMapper<>(Account.class), id);
        if (accounts.isEmpty()) {
            return null;
        }
        if (accounts.size() > 1) {
            throw new RuntimeException("存在重复ID账户");
        }
        return accounts.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> accounts = getJdbcTemplate().query("select * from account where name = ?", new BeanPropertyRowMapper<>(Account.class), name);
        if (accounts.isEmpty()) {
            return null;
        }
        if (accounts.size() > 1) {
            throw new RuntimeException("存在重名账户");
        }
        return accounts.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        getJdbcTemplate().update("update account set name = ?, money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
    }
}
