package com.yakumo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yakumo.dao.BookDao;
import com.yakumo.domain.Book;
import com.yakumo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Author cho1r
 * 13/2/2022 上午11:20
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> page = new Page<>(currentPage, pageSize);
        return bookDao.selectPage(page, null);
    }
}
