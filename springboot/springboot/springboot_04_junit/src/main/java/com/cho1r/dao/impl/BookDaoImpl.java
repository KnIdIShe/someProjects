package com.cho1r.dao.impl;

import com.cho1r.dao.BookDao;
import org.springframework.stereotype.Repository;

/**
 * Author cho1r
 * 12/2/2022 下午2:12
 */
@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao is running...");
    }
}
