package com.cho1r.dao;

import com.cho1r.domain.QueryVo;
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
     * 根据名称模糊查询
     *
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 根据 QueryVo 中的条件查询用户
     *
     * @param queryVo
     * @return
     */
    List<User> findByQueryVo(QueryVo queryVo);

    /**
     * 根据传入的参数条件查询
     * @param user
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 查询 id 在集合中的用户
     * @param queryVo
     * @return
     */
    List<User> findUserInIds(QueryVo queryVo);
}
