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

/**
 * Author cho1r
 * 2022/01/04 下午 07:41
 * 测试 mybatis 的 CRUD 操作
 */
public class SecondLevelCacheTest {

    private InputStream inputStream;
    private SqlSessionFactory factory;

    @Before // 用于在测试方法执行之前执行
    public void init() throws IOException {
        // 读取配置文件, 生成字节输入流
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取 SqlSessionFactory
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @After // 用于在测试方法执行之后执行
    public void destroy() throws IOException {
        // 释放资源
        inputStream.close();
    }


    /**
     * 测试二级缓存
     */
    @Test
    public void testSecondLevelCache() throws IOException {

        SqlSession sqlSession1 = factory.openSession();
        IUserDao userDao1 = sqlSession1.getMapper(IUserDao.class);
        User user1 = userDao1.findById(41);
        System.out.println(user1);
        sqlSession1.close();

        SqlSession sqlSession2 = factory.openSession();
        IUserDao userDao2 = sqlSession2.getMapper(IUserDao.class);
        User user2 = userDao2.findById(41);
        System.out.println(user2);
        sqlSession2.close();

        System.out.println(user1 == user2);

    }
}
