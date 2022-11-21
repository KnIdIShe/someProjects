package com.cho1r.dao;

import com.cho1r.domain.Account;

import java.util.List;

/**
 * Author cho1r
 * 2021/12/21 下午 06:05
 * 账户的持久层接口
 */
public interface IAccountDao {

    Account findAccountByName(String name);

    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 根据id查询单个
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param accountId
     */
    void deleteAccount(Integer accountId);

}
