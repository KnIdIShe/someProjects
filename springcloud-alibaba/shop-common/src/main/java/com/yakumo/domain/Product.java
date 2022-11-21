package com.yakumo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Author cho1r
 * 2022/03/21 10:58
 */
//商品
@Entity(name = "shop_product")
@Data
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;//主键
    private String pname;//商品名称
    private Double pprice;//商品价格
    private Integer stock;//库存
}
