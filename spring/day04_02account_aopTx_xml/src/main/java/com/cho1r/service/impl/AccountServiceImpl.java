package com.cho1r.service.impl;

import com.cho1r.dao.IAccountDao;
import com.cho1r.domain.Account;
import com.cho1r.service.IAccountService;
import com.cho1r.utils.ConnectionUtils;
import com.cho1r.utils.TransactionManager;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

import java.util.List;

/**
 * Author cho1r
 * 2021/12/21 下午 05:50
 */
public class AccountServiceImpl implements IAccountService {

    @Pointcut("execution(* com.cho1r.service.impl.*.*(..))")
    private void pt1() {
    }

    private IAccountDao accountDao;

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
//        int i = 1 / 0;

        // 更新转入账户
        accountDao.updateAccount(target);

    }

    @Override
    public List<Account> findAllAccount() {

        // 执行操作
        return accountDao.findAllAccount();

    }

    @Override
    public Account findAccountById(Integer accountId) {

        // 执行操作
        return accountDao.findAccountById(accountId);

    }

    @Override
    public void saveAccount(Account account) {

        // 执行操作
        accountDao.saveAccount(account);

    }

    @Override
    public void updateAccount(Account account) {

        // 执行操作
        accountDao.updateAccount(account);

    }

    @Override
    public void deleteAccount(Integer accountId) {

        // 执行操作
        accountDao.deleteAccount(accountId);

    }
}
