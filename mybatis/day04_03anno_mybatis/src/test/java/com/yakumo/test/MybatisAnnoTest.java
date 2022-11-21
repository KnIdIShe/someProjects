package com.yakumo.test;

import com.yakumo.dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Author cho1r
 * 2022/01/09 下午 02:11
 */
public class MybatisAnnoTest {

    @Test
    public void testAnno() throws IOException {
        // 获取字节输入流
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 根据字节输入流构建 SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 使用 SqlSessionFactory 生产 SqlSession
        SqlSession sqlSession = factory.openSession();
        // 使用 SqlSession 获取 dao 的代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        // 执行方法
        userDao.findAll().forEach(System.out::println);
    }
}
