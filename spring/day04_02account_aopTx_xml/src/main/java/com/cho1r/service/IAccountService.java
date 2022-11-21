package com.cho1r.service;

import com.cho1r.domain.Account;

import java.util.List;

/**
 * Author cho1r
 * 2021/12/21 下午 05:36
 * 账户的业务层接口
 */
public interface IAccountService {

    /**
     * 根据名字查询账户
     * @param name
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 转账
     * @param sourceName
     * @param targetName
     * @param money
     */
    void transfer(String sourceName, String targetName, double money);

    /**
     * 查询所有
     *
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 根据id查询单个
     *
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     *
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     *
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     *
     * @param accountId
     */
    void deleteAccount(Integer accountId);

}
