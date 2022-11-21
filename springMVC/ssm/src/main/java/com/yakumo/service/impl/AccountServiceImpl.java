package com.yakumo.service.impl;

import com.yakumo.dao.IAccountDao;
import com.yakumo.domain.Account;
import com.yakumo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author cho1r
 * 12/1/2022 下午9:03
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("service findAll");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("service saveAccount");
        accountDao.saveAccount(account);
    }
}
