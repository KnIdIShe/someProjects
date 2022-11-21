package com.cho1r.test;

import com.cho1r.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Author cho1r
 * 2021/12/21 下午 07:51
 * 使用junit进行单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
//    @Qualifier("proxyAccountService")
    private IAccountService accountService;

    @Test
    public void testTransfer() {
        accountService.transfer("tom", "iris", 100);
    }

}
