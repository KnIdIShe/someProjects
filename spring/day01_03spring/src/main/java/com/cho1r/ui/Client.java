package com.cho1r.ui;

import com.cho1r.dao.IAccountDao;
import com.cho1r.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Author cho1r
 * 2021/12/19 下午 06:38
 * 模拟表现层调用业务层
 */
public class Client {
    /**
     * 获取spring的Ioc核心容器, 并根据id获取对象
     * ApplicationContext: 读取配置文件, 立即加载, 创建对象, 饿汉式, 适合单例对象
     * BeanFactory: 延迟加载, 懒汉式, 适合多例对象
     *
     * @param args
     */
    public static void main(String[] args) {
//        // 获取核心容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
////        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("E:\\program\\java\\workspace\\spring\\day01_03spring\\src\\main\\resources\\bean.xml");
//        // 根据id获取Bean对象
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
        IAccountDao accountDao = applicationContext.getBean("accountDao", IAccountDao.class);
////        IAccountDao accountDao2 = applicationContext.getBean(IAccountDao.class);
//
//        System.out.println(accountDao);
////        System.out.println(accountDao2);
//        System.out.println(accountService);
        accountService.saveAccount();


        // -------------BeanFactory----------------
//        Resource resource = new ClassPathResource("bean.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);
//        IAccountService accountService = factory.getBean("accountService", IAccountService.class);
//        System.out.println(accountService);
    }
}
