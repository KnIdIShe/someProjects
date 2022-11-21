package com.cho1r.dao;

import com.cho1r.domain.Account;
import com.cho1r.domain.AccountUser;

import java.util.List;

/**
 * Author cho1r
 * 2022/01/07 下午 06:21
 */
public interface IAccountDao {

    /**
     * 查询所有账户
     *
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户, 同时包含用户名和地址
     *
     * @return
     */
    List<AccountUser> findAllAccountUser();
}
