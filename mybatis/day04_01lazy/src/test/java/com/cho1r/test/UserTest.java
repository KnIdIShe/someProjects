package com.cho1r.test;

import com.cho1r.dao.IUserDao;
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
import java.util.*;

/**
 * Author cho1r
 * 2022/01/04 下午 07:41
 * 测试 mybatis 的 CRUD 操作
 */
public class UserTest {

    private InputStream inputStream;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before // 用于在测试方法执行之前执行
    public void init() throws IOException {
        // 读取配置文件, 生成字节输入流
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取 SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取 SqlSession
        sqlSession = factory.openSession(true);
        // 获取 dao 的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
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
        for (User user : userDao.findAll()) {
//            System.out.println("----------------存在账户的用户----------------");
//            System.out.println(user);
//            System.out.println(user.getAccounts());
        }

    }
}
