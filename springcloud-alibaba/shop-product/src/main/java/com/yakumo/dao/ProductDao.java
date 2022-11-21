package com.yakumo.dao;

import com.yakumo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author cho1r
 * 2022/03/21 11:53
 */
@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
}
