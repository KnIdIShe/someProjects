package com.cho1r.service;

import com.cho1r.domain.Account;

/**
 * Author cho1r
 * 2021/12/31 下午 06:13
 * 账户的业务层接口
 */
public interface IAccountService {

    /**
     * 根据 ID 查询账户信息
     *
     * @param accountId
     * @return
     */
    Account findAccountById(int accountId);

    /**
     * 转账
     *
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money      转账金额
     */
    void transfer(String sourceName, String targetName, double money);
}
