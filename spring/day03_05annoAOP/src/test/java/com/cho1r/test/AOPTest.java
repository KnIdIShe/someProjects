package com.cho1r.test;

import com.cho1r.config.SpringConfig;
import com.cho1r.service.IAccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author cho1r
 * 2021/12/26 下午 04:10
 */
public class AOPTest {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        IAccountService accountService = applicationContext.getBean(IAccountService.class);

        accountService.saveAccount();

    }
}
