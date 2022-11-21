package com.cho1r.service.impl;

import com.cho1r.service.IAccountService;

import java.util.Date;

/**
 * Author cho1r
 * 2021/12/19 下午 06:29
 * 账户的业务层实现类
 */
public class AccountServiceImpl2 implements IAccountService {
//    private IAccountDao accountDao;

    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public void saveAccount() {
//        accountDao.saveAccount();
        System.out.println("service中的saveAccount()方法被执行.");
        System.out.println(name + ", " + age + ", " + birthday);
    }

}
