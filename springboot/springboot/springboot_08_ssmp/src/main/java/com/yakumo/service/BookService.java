package com.yakumo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yakumo.domain.Book;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author cho1r
 * 13/2/2022 上午10:24
 */
public interface BookService {
    Boolean save(Book book);

    Boolean update(Book book);

    Boolean delete(long id);

    Book getById(long id);

    List<Book> getAll();

    IPage<Book> getPage(int currentPage, int pageSize);
}
