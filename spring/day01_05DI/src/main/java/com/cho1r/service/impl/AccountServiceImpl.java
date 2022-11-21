package com.cho1r.service.impl;

import com.cho1r.dao.IAccountDao;
import com.cho1r.service.IAccountService;
import com.cho1r.dao.impl.AccountDaoImpl;
import org.springframework.beans.factory.BeanFactory;

import java.util.Date;

/**
 * Author cho1r
 * 2021/12/19 下午 06:29
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
//    private IAccountDao accountDao;

    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public void saveAccount() {
//        accountDao.saveAccount();
        System.out.println("service中的saveAccount()方法被执行.");
        System.out.println(name + ", " + age + ", " + birthday);
    }

}
