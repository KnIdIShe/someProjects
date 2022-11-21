package com.yakumo.dao;

import com.yakumo.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author cho1r
 * 12/1/2022 下午8:51
 * 账户 dao 接口
 */
@Repository
public interface IAccountDao {

    // 查询所有账户
    @Select("select * from account")
    List<Account> findAll();

    // 保存账户
    @Insert("insert into account (name, money) values (#{name}, #{money})")
    void saveAccount(Account account);
}
