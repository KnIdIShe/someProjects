package com.yakumo.test;

import com.yakumo.dao.IAccountDao;
import com.yakumo.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author cho1r
 * 2022/01/09 下午 04:17
 */
public class AccountTest {

    private InputStream inputStream;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = factory.openSession(true);
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testFindAll() {

        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("--------------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

}
