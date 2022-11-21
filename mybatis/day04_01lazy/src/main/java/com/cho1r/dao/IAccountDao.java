package com.cho1r.dao;

import com.cho1r.domain.Account;

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
     * 根据用户id查询账户信息
     * @return
     */
    List<Account> findAccountByUid(long uid);

}
