package com.cho1r.service.impl;

import com.cho1r.dao.IAccountDao;
import com.cho1r.domain.Account;
import com.cho1r.service.IAccountService;
import com.cho1r.utils.TransactionManager;

import java.util.List;

/**
 * Author cho1r
 * 2021/12/21 下午 05:50
 */
public class AccountServiceImpl_old implements IAccountService {

    private IAccountDao accountDao;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccountByName(String name) {
        return accountDao.findAccountByName(name);
    }

    @Override
    public void transfer(String sourceName, String targetName, double money) {
        System.out.println("transfer...");

        try {
            // 开启事务
            transactionManager.startTransaction();
            // 执行操作
            // 获取转出账户
            Account source = accountDao.findAccountByName(sourceName);
            // 获取转入账户
            Account target = accountDao.findAccountByName(targetName);
            // 转出账户减钱
            source.setMoney(source.getMoney() - money);
            // 转入账户加钱
            target.setMoney(target.getMoney() + money);
            // 更新转出账户
            accountDao.updateAccount(source);

            // 手动异常
            int i = 1 / 0;

            // 更新转入账户
            accountDao.updateAccount(target);
            // 提交事务
            transactionManager.commit();
        } catch (Exception e) {
            // 回滚事务
            transactionManager.rollback();
            e.printStackTrace();
        } finally {
            transactionManager.release();
        }
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            // 开启事务
            transactionManager.startTransaction();
            // 执行操作
            List<Account> accounts = accountDao.findAllAccount();
            // 提交事务
            transactionManager.commit();
            // 返回结果
            return accounts;
        } catch (Exception e) {
            // 回滚事务
            transactionManager.rollback();
        } finally {
            transactionManager.release();
        }
        return null;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            // 开启事务
            transactionManager.startTransaction();
            // 执行操作
            Account account = accountDao.findAccountById(accountId);
            // 提交事务
            transactionManager.commit();
            // 返回结果
            return account;
        } catch (Exception e) {
            // 回滚事务
            transactionManager.rollback();
        } finally {
            transactionManager.release();
        }
        return null;
    }

    @Override
    public void saveAccount(Account account) {
        try {
            // 开启事务
            transactionManager.startTransaction();
            // 执行操作
            accountDao.saveAccount(account);
            // 提交事务
            transactionManager.commit();
        } catch (Exception e) {
            // 回滚事务
            transactionManager.rollback();
        } finally {
            transactionManager.release();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            // 开启事务
            transactionManager.startTransaction();
            // 执行操作
            accountDao.updateAccount(account);
            // 提交事务
            transactionManager.commit();
        } catch (Exception e) {
            // 回滚事务
            transactionManager.rollback();
        } finally {
            transactionManager.release();
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            // 开启事务
            transactionManager.startTransaction();
            // 执行操作
            accountDao.deleteAccount(accountId);
            // 提交事务
            transactionManager.commit();
        } catch (Exception e) {
            // 回滚事务
            transactionManager.rollback();
        } finally {
            transactionManager.release();
        }
    }
}
