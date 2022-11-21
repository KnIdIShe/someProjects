package com.yakumo.service;

import com.yakumo.domain.Account;

import java.util.List;

/**
 * Author cho1r
 * 12/1/2022 下午8:51
 * 账户 service 接口
 */
public interface IAccountService {

    // 查询所有账户
    List<Account> findAll();

    // 保存账户
    void saveAccount(Account account);
}
