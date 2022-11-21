package com.cho1r.service;

/**
 * Author cho1r
 * 2021/12/26 下午 03:09
 * 账户的业务层接口
 */
public interface IAccountService {
    void saveAccount();

    void updateAccount(int i);

    int deleteAccount();
}
