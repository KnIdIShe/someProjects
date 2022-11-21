package com.yakumo.controller;

import com.alibaba.fastjson.JSON;
import com.yakumo.domain.Product;
import com.yakumo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author cho1r
 * 2022/03/21 11:52
 */
@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    // 查询商品信息
    @RequestMapping("/product/{pid}")
    public Product product(@PathVariable("pid") Integer pid) {
        log.info("查询商品{}信息...", pid);
        Product product = productService.findByPid(pid);

        log.info("商品{}信息查询成功: {}", pid, JSON.toJSONString(product));
        return product;
    }
}
