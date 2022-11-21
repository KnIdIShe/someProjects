package com.yakumo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yakumo.dao.BookDao;
import com.yakumo.domain.Book;
import com.yakumo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author cho1r
 * 13/2/2022 上午10:35
 */
@Service
public class BookServiceImpl_old implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book) == 1;
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book) == 1;
    }

    @Override
    public Boolean delete(long id) {
        return bookDao.deleteById(id) == 1;
    }

    @Override
    public Book getById(long id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> page = new Page<>(currentPage, pageSize);
        bookDao.selectPage(page, null);
        return page;
    }
}
