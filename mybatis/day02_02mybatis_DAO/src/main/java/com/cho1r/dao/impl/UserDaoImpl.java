package com.cho1r.dao.impl;

import com.cho1r.dao.IUserDao;
import com.cho1r.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Author cho1r
 * 2022/01/06 上午 10:17
 */
public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<User> findAll() {
        // 根据 factory 获取 SqlSession 对象
        SqlSession session = factory.openSession();
        // 调用 SqlSession 中的方法, 实现查询列表
        List<User> users = session.selectList("com.cho1r.dao.IUserDao.findAll");// 参数为获取配置信息的 key
        // 释放资源
        session.close();
        return users;
    }

    @Override
    public void saveUser(User user) {
        // 根据 factory 获取 SqlSession 对象
        SqlSession session = factory.openSession();
        // 调用 SqlSession 中的方法, 实现保存
        session.insert("com.cho1r.dao.IUserDao.saveUser", user);
        // 释放资源
        session.commit();
        session.close();
    }

    @Override
    public void updateUser(User user) {
        // 根据 factory 获取 SqlSession 对象
        SqlSession session = factory.openSession();
        // 调用 SqlSession 中的方法, 实现更新
        session.insert("com.cho1r.dao.IUserDao.updateUser", user);
        // 释放资源
        session.commit();
        session.close();
    }

    @Override
    public void deleteUser(long userId) {
        // 根据 factory 获取 SqlSession 对象
        SqlSession session = factory.openSession();
        // 调用 SqlSession 中的方法, 实现更新
        session.insert("com.cho1r.dao.IUserDao.deleteUser", userId);
        // 释放资源
        session.commit();
        session.close();
    }

    @Override
    public User findById(long userId) {
        // 根据 factory 获取 SqlSession 对象
        SqlSession session = factory.openSession();
        // 调用 SqlSession 中的方法, 实现查询列表
        User user = session.selectOne("com.cho1r.dao.IUserDao.findById", userId);// 参数为获取配置信息的 key
        // 释放资源
        session.close();
        return user;
    }

    @Override
    public List<User> findByName(String name) {
        // 根据 factory 获取 SqlSession 对象
        SqlSession session = factory.openSession();
        // 调用 SqlSession 中的方法, 实现查询列表
        List<User> users = session.selectList("com.cho1r.dao.IUserDao.findByName", ("%" + name + "%"));// 参数为获取配置信息的 key
        // 释放资源
        session.close();
        return users;
    }

    @Override
    public int findTotal() {
        // 根据 factory 获取 SqlSession 对象
        SqlSession session = factory.openSession();
        // 调用 SqlSession 中的方法, 实现查询列表
        int count = session.selectOne("com.cho1r.dao.IUserDao.findTotal");// 参数为获取配置信息的 key
        // 释放资源
        session.close();
        return count;
    }
}
