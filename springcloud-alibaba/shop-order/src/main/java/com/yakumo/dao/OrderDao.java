package com.yakumo.dao;

import com.yakumo.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author cho1r
 * 2022/03/21 11:53
 */
public interface OrderDao extends JpaRepository<Order, Integer> {
}
