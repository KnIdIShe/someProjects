package com.cho1r.test;

import com.cho1r.config.JdbcConfig;
import com.cho1r.config.SpringConfig;
import com.cho1r.domain.Account;
import com.cho1r.service.IAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Author cho1r
 * 2021/12/21 下午 07:51
 * 使用junit进行单元测试
 */
public class AccountServiceTest {
    @Test
    public void testFindAll() {
        // 获取容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.cho1r");
        // 获取业务层对象
        IAccountService accountService = applicationContext.getBean(IAccountService.class);
        // 执行方法
        List<Account> accounts = accountService.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        // 获取容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.cho1r");
        // 获取业务层对象
        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        // 执行方法
        System.out.println(accountService.findAccountById(400));
    }

    @Test
    public void testSave() {
        // 获取容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.cho1r");
        // 获取业务层对象
        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        // 执行方法
        Account account = new Account("tom", 2300);
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        // 获取容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.cho1r");
        // 获取业务层对象
        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        // 执行方法
        Account account = accountService.findAccountById(400);
        account.setMoney(23456);
        accountService.updateAccount(account);
    }

    @Test
    public void testDelete() {
        // 获取容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.cho1r");
        // 获取业务层对象
        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        // 执行方法
        accountService.deleteAccount(400);
    }

}
