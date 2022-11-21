package com.yakumo.dao;

import com.yakumo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Author cho1r
 * 2022/01/09 下午 12:59
 */
public interface IUserDao {

    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     *
     * @param user
     */
    @Insert("insert into user (name, sex, birthday, address) values (#{name}, #{sex}, #{birthday}, #{address})")
    void saveUser(User user);

    /**
     * 更新用户
     *
     * @param user
     */
    @Update("update user set name = #{name} where id = #{id}")
    void updateUser(User user);

    /**
     * 删除用户
     *
     * @param id
     */
    @Update("delete from user where id = #{id}")
    void deleteUser(long id);

    /**
     * 查询单个用户
     *
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User findById(long id);

    /**
     * 根据名称模糊查询
     *
     * @param name
     * @return
     */
//    @Select("select * from user where name like #{name}")
    @Select("select * from user where name like '%${value}%'")
    List<User> findUserByName(String name);

    /**
     * 查询用户数
     *
     * @return
     */
    @Select("select count(*) from user")
    long findTotal();
}
