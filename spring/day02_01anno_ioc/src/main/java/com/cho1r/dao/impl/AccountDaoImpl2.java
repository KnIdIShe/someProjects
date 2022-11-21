package com.cho1r.dao.impl;

import com.cho1r.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * Author cho1r
 * 2021/12/19 下午 06:33
 * 账户的持久层实现类
 */
@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {

    @Override
    public void saveAccount() {
        System.out.println("已保存账户至数据库.22222222");
    }
}
