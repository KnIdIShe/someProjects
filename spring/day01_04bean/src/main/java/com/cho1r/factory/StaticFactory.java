package com.cho1r.factory;

import com.cho1r.service.IAccountService;
import com.cho1r.service.impl.AccountServiceImpl;

/**
 * Author cho1r
 * 2021/12/20 下午 05:18
 */
public class StaticFactory {
    public static IAccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
