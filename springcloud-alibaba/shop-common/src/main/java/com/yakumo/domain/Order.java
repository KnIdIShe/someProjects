package com.yakumo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Author cho1r
 * 2022/03/21 11:00
 */
//订单
@Entity(name = "shop_order")
@Data
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;//订单id

    // 用户 user
    private Integer uid;//用户id
    private String username;//用户名

    // 商品 product
    private Integer pid;//商品id
    private String pname;//商品名称
    private Double pprice;//商品单价

    // 数量
    private Integer number;//购买数量
}
