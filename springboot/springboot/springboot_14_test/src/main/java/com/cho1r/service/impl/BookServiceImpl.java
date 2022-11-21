package com.cho1r.service.impl;

import com.cho1r.dao.BookDao;
import com.cho1r.domain.Book;
import com.cho1r.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author cho1r
 * 17/2/2022 上午9:33
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        return bookDao.insert(book) == 1;
    }
}
