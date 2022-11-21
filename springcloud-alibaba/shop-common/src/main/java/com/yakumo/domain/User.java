package com.yakumo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Author cho1r
 * 2022/03/21 10:47
 */
//用户
@Entity(name = "shop_user") // 实体类与数据表的映射
@Data // getter, setter
public class User implements Serializable {
    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 数据库自增
    private Integer uid;//主键
    private String username;//用户名
    private String password;//密码
    private String telephone;//手机号
}
