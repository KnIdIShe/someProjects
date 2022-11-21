package com.cho1r.dao.impl;

import com.cho1r.dao.IAccountDao;
import com.cho1r.domain.Account;
import com.cho1r.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Author cho1r
 * 2021/12/21 下午 06:14
 * 账户的持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner queryRunner;
    @Autowired
    private ConnectionUtils connectionUtils;

    @Override
    public Account findAccountByName(String name) {
        try {
            List<Account> accounts = queryRunner.query(connectionUtils.getThreadConnection(), "select * from account where name = ?", new BeanListHandler<>(Account.class), name);
            if (accounts.size() > 1) {
                throw new RuntimeException("存在同名账户.");
            }
            if (accounts == null) {
                throw new RuntimeException("不存在该账户.");
            }
            return accounts.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            return queryRunner.query(connectionUtils.getThreadConnection(), "select * from account", new BeanListHandler<>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            return queryRunner.query(connectionUtils.getThreadConnection(), "select * from account where id = ?", new BeanHandler<>(Account.class), accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveAccount(Account account) {
        try {
            queryRunner.update(connectionUtils.getThreadConnection(), "insert into account (name, money) values (?, ?)", account.getName(), account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            queryRunner.update(connectionUtils.getThreadConnection(), "update account set name = ?, money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            queryRunner.update(connectionUtils.getThreadConnection(), "delete from account where id = ?", accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
