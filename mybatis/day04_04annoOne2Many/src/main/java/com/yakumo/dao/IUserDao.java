package com.yakumo.dao;

import com.yakumo.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * Author cho1r
 * 2022/01/09 下午 12:59
 */
@CacheNamespace(blocking = true)
public interface IUserDao {

    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMap", value = {@Result(id = true, property = "userId", column = "id"),
            @Result(property = "userName", column = "name"),
            @Result(property = "userSex", column = "sex"),
            @Result(property = "userBirthday", column = "birthday"),
            @Result(property = "userAddress", column = "address"),
            @Result(property = "accounts", column = "id", many = @Many(select = "com.yakumo.dao.IAccountDao.findByUid", fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 查询单个用户
     *
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    @Results(id = "userMap2", value = {@Result(id = true, property = "userId", column = "id"),
            @Result(property = "userName", column = "name"),
            @Result(property = "userSex", column = "sex"),
            @Result(property = "userBirthday", column = "birthday"),
            @Result(property = "userAddress", column = "address")
    })
    User findById(long id);

}
