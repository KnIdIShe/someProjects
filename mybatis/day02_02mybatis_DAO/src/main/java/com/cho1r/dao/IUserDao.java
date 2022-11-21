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
     * 保存用户
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     */
    void updateUser(User user);

    /**
     * 根据 id 删除用户
     * @param userID
     */
    void deleteUser(long userID);

    /**
     * 根据 id 查找用户
     * @param userID
     * @return
     */
    User findById(long userID);

    /**
     * 根据名称模糊查询
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 查询总用户数
     * @return
     */
    int findTotal();
}
