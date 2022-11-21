package com.cho1r.dao;

import com.cho1r.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Author cho1r
 * 2022/01/02 下午 05:12
 * 用户的持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from account")
    List<User> findAll();
}
