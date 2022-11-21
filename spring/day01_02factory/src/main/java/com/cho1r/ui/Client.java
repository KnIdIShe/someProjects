package com.cho1r.ui;

import com.cho1r.factory.BeanFactory;
import com.cho1r.service.IAccountService;

/**
 * Author cho1r
 * 2021/12/19 下午 06:38
 * 模拟表现层调用业务层
 */
public class Client {
    public static void main(String[] args) {
//        IAccountService accountService = new AccountServiceImpl();
//        IAccountService accountService = (IAccountService) BeanFactory.getBean("accountService");
//
//        accountService.saveAccount();


        IAccountService accountService;
        for (int i = 0; i < 5; i++) {
            accountService = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(accountService);
            accountService.saveAccount();
        }
    }
}
