package com.cho1r.service.impl;

import com.cho1r.dao.IAccountDao;
import com.cho1r.service.IAccountService;
import com.cho1r.dao.impl.AccountDaoImpl;
import org.springframework.beans.factory.BeanFactory;

/**
 * Author cho1r
 * 2021/12/19 下午 06:29
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
