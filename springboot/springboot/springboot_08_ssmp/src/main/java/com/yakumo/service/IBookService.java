package com.yakumo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yakumo.domain.Book;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Author cho1r
 * 13/2/2022 上午11:19
 */
public interface IBookService extends IService<Book> {

    IPage<Book> getPage(int currentPage, int pageSize);
}
