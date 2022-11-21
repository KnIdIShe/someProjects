package com.cho1r.dao;

import com.cho1r.domain.User;

import java.util.List;

/**
 * Author cho1r
 * 2022/01/04 下午 07:33
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> findAll();

    /**
     * 根据 id 查找用户
     *
     * @param userId
     * @return
     */
    User findById(long userId);

    /**
     * 更新用户信息
     *
     * @param user
     */
    void updateUser(User user);
}
