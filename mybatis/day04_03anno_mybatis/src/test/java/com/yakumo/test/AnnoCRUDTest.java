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
import java.util.Date;

/**
 * Author cho1r
 * 2022/01/09 下午 04:17
 */
public class AnnoCRUDTest {

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
    public void testSave() {
        User user = new User();
        user.setName("jerry");
        user.setSex('F');
        user.setBirthday(new Date("2012/01/03"));
        user.setAddress("Michigan No.12");

        userDao.saveUser(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setName("iris");
        user.setId(50);

        userDao.updateUser(user);
    }

    @Test
    public void testDelete() {

        userDao.deleteUser(50);
    }

    @Test
    public void testFindOne() {

        System.out.println(userDao.findById(48));
    }

    @Test
    public void testFindByName() {

//        userDao.findUserByName(String.format("%%%s%%", "王"));
        userDao.findUserByName("王");
    }

    @Test
    public void testFindTotal() {

        System.out.println(userDao.findTotal());
    }
}
