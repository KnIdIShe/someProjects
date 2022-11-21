package com.yakumo.test;

import com.yakumo.dao.IUserDao;
import com.yakumo.domain.User;
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
 * 2022/01/09 下午 04:17
 */
public class SecondLevelCacheTest {

    private InputStream inputStream;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = factory.openSession(true);
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testFindOne() {

        System.out.println(userDao.findById(48));

        sqlSession.close();

        System.out.println(factory.openSession(true).getMapper(IUserDao.class).findById(48));
    }

}
