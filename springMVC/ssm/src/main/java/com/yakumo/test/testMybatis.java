package com.yakumo.test;

import com.yakumo.dao.IAccountDao;
import com.yakumo.domain.Account;
import com.yakumo.service.IAccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author cho1r
 * 13/1/2022 下午1:28
 */
public class testMybatis {

    @Test
    public void test01() throws IOException {
        // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession(true);
        // 获取代理对象
        IAccountDao accountDao = session.getMapper(IAccountDao.class);
        // 调用方法
        List<Account> accounts = accountDao.findAll();
        accounts.forEach(System.out::println);
        // 释放资源
        session.close();
        inputStream.close();
    }
}
