package com.yakumo.service;

import com.yakumo.domain.Product;

/**
 * Author cho1r
 * 2022/03/21 11:52
 */
public interface ProductService {

    // 根据 pid 查询商品信息
    Product findByPid(Integer pid);
}
