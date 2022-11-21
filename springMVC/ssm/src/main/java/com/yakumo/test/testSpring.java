package com.yakumo.test;

import com.yakumo.service.IAccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author cho1r
 * 13/1/2022 下午1:28
 */
public class testSpring {

    @Test
    public void test01() {
        // 加载配置文件
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取对象
        IAccountService accountService = applicationContext.getBean(IAccountService.class);
        // 调用方法
        accountService.findAll();
    }
}
