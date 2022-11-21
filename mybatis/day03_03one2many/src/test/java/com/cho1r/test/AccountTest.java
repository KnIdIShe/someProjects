package com.cho1r.test;

import com.cho1r.dao.IAccountDao;
import com.cho1r.dao.IUserDao;
import com.cho1r.domain.Account;
import com.cho1r.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Author cho1r
 * 2022/01/04 下午 07:41
 * 测试 account 的 CRUD 操作
 */
public class AccountTest {

    private InputStream inputStream;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

    @Before // 用于在测试方法执行之前执行
    public void init() throws IOException {
        // 读取配置文件, 生成字节输入流
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取 SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取 SqlSession
        sqlSession = factory.openSession(true);// 自动提交 true
        // 获取 dao 的代理对象
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After // 用于在测试方法执行之后执行
    public void destroy() throws IOException {
        // 提交事务
//        sqlSession.commit();
        // 释放资源
        sqlSession.close();
        inputStream.close();
    }


    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() throws IOException {
        // 执行方法
        for (Account account : accountDao.findAll()) {
            System.out.println("-----------------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    /**
     * 查询所有账户, 同时包含用户名和地址
     */
    @Test
    public void testFindAllAccount() throws IOException {
        // 执行方法
        for (Account account : accountDao.findAllAccountUser()) {
            System.out.println(account);
        }
    }

}
