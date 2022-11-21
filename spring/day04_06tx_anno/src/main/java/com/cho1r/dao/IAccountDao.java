package com.cho1r.dao;

import com.cho1r.domain.Account;

/**
 * Author cho1r
 * 2021/12/28 下午 01:16
 * 账户的持久层接口
 */
public interface IAccountDao {

    /**
     * 根据ID查询账户
     *
     * @return
     */
    Account findAccountById(long id);

    /**
     * 根据ID查询账户
     *
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 更新账户
     *
     * @param account
     */
    void updateAccount(Account account);
}
