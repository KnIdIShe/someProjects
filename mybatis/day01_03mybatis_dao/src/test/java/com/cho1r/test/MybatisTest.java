package com.cho1r.test;

import com.cho1r.dao.IUserDao;
import com.cho1r.dao.impl.UserDaoImpl;
import com.cho1r.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author cho1r
 * 2022/01/02 下午 07:21
 */
public class MybatisTest {
    public static void main(String[] args) throws IOException {

        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建 SqlSessionFactory 工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        // 使用 工厂 创建 Dao 对象
        UserDaoImpl userDao = new UserDaoImpl(factory);
        // 使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        // 释放资源
        inputStream.close();


    }
}
