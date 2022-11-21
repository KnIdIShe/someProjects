package com.cho1r.dao.impl;

import com.cho1r.dao.IUserDao;
import com.cho1r.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Author cho1r
 * 2022/01/03 上午 09:56
 */
public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<User> findAll() {
        // 使用工厂创建 SqlSession 对象
        SqlSession session = factory.openSession();
        // 使用 session 执行方法
        List<User> users = session.selectList("com.cho1r.dao.IUserDao.findAll");
        session.close();
        // 返回查询结果
        return users;
    }
}
