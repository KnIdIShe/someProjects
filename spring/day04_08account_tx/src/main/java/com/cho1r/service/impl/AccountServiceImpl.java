package com.cho1r.service.impl;

import com.cho1r.dao.IAccountDao;
import com.cho1r.domain.Account;
import com.cho1r.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Author cho1r
 * 2021/12/21 下午 05:50
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public Account findAccountById(int accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public void transfer(String sourceName, String targetName, double money) {

        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
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
                int i = 1 / 0;

                // 更新转入账户
                accountDao.updateAccount(target);
                return null;
            }
        });



    }
}
