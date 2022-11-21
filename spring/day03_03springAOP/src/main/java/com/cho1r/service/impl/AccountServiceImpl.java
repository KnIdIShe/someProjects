package com.cho1r.service.impl;

import com.cho1r.service.IAccountService;

/**
 * Author cho1r
 * 2021/12/26 下午 03:16
 */
public class AccountServiceImpl implements IAccountService {
    @Override
    public void saveAccount() {
        System.out.println("执行了保存.");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("执行了更新. " + i);
    }

    @Override
    public int deleteAccount() {
        System.out.println("执行了删除.");
        return 0;
    }
}
