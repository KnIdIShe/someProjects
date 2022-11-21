package com.cho1r.test;

import com.cho1r.dao.IUserDao;
import com.cho1r.domain.User;
import com.cho1r.mybatis.io.Resources;
import com.cho1r.mybatis.sqlSession.SqlSession;
import com.cho1r.mybatis.sqlSession.SqlSessionFactory;
import com.cho1r.mybatis.sqlSession.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * Author cho1r
 * 2022/01/02 下午 07:21
 */
public class MybatisTest {
    public static void main(String[] args) throws IOException, SQLException {

        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建 SqlSessionFactory 工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        // 使用工厂创建 SqlSession 对象
        SqlSession session = factory.openSession();
        // 使用 SqlSession 创建 Dao 接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        // 使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        // 释放资源
        session.close();
        inputStream.close();


    }
}
