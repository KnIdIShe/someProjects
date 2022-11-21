package com.cho1r.test;

import com.cho1r.domain.Account;
import com.cho1r.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Author cho1r
 * 2021/12/21 下午 07:51
 * 使用junit进行单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private IAccountService accountService;

    @Test
    public void testFindAll() {
        // 执行方法
        List<Account> accounts = accountService.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        // 执行方法
        System.out.println(accountService.findAccountById(400));
    }

    @Test
    public void testSave() {
        // 执行方法
        Account account = new Account("tom", 2300);
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        // 执行方法
        Account account = accountService.findAccountById(400);
        account.setMoney(23456);
        accountService.updateAccount(account);
    }

    @Test
    public void testDelete() {
        // 执行方法
        accountService.deleteAccount(400);
    }

}
