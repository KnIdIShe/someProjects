package com.cho1r.test;

import com.cho1r.dao.IUserDao;
import com.cho1r.domain.QueryVo;
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
import java.text.DateFormat;
import java.util.Date;

/**
 * Author cho1r
 * 2022/01/04 下午 07:41
 * 测试 mybatis 的 CRUD 操作
 */
public class MybatisTest {

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
        sqlSession = factory.openSession();
        // 获取 dao 的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After // 用于在测试方法执行之后执行
    public void destroy() throws IOException {
        // 提交事务
        sqlSession.commit();
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
            System.out.println(user);
        }

    }

    @Test
    public void testSave() {
        User user = new User("chika", 2300, new Date("2012/01/03"));
        System.out.println(user);
        userDao.saveUser(user);
        System.out.println(user);
    }

    @Test
    public void testUpdate() {
        User user = new User("haki", 2300, new Date("2012/01/03"));
        user.setId(8);
        userDao.updateUser(user);
    }

    @Test
    public void testDelete() {
        userDao.deleteUser(8L);
    }

    @Test
    public void testFindOne() {
        System.out.println(userDao.findById(5));
    }

    @Test
    public void testFindByName() {
        String name = "a";
//        userDao.findByName("%" + name + "%").forEach(System.out::println);
        userDao.findByName(name).forEach(System.out::println);
    }

    @Test
    public void testFindTotal() {
        System.out.println(userDao.findTotal());
    }

    @Test
    public void testFindByVo() {
        QueryVo queryVo = new QueryVo();
        queryVo.setUser(new User("%a%", 2300, new Date("2012/01/03")));
        userDao.findByQueryVo(queryVo).forEach(System.out::println);
    }
}
