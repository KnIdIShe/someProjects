package com.yakumo.service.impl;

import com.yakumo.dao.ProductDao;
import com.yakumo.domain.Product;
import com.yakumo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author cho1r
 * 2022/03/21 11:53
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product findByPid(Integer pid) {
        return productDao.findById(pid).get();
    }
}
