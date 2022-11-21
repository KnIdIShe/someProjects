package com.yakumo.dao;

import com.yakumo.domain.Account;
import com.yakumo.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * Author cho1r
 * 2022/01/09 下午 07:12
 */
public interface IAccountDao {

    /**
     * 查询所有账户, 及账户对应的用户信息
     *
     * @return
     */
    @Select("select * from account")
    @Results({@Result(id = true, property = "id", column = "id"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "money", column = "money"),
            @Result(property = "user", column = "uid", one = @One(select = "com.yakumo.dao.IUserDao.findById", fetchType = FetchType.EAGER))})
    List<Account> findAll();

    /**
     * 查询单个账户
     *
     * @param uid
     * @return
     */
    @Select("select * from account where uid = #{uid}")
    Account findByUid(long uid);
}
