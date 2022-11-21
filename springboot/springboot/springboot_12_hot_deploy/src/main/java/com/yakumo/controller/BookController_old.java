package com.yakumo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yakumo.domain.Book;
import com.yakumo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author cho1r
 * 13/2/2022 下午1:25
 */
//@RestController
@RequestMapping("/books")
public class BookController_old {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public List<Book> getAll() {
        return bookService.list();
    }

    @PostMapping
    public boolean save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping
    public boolean update(@RequestBody Book book) {
        return bookService.updateById(book);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        return bookService.removeById(id);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable long id) {
        return bookService.getById(id);
    }

//    @GetMapping("/{currentPage}/{pageSize}")
//    public IPage<Book> getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
//        return bookService.getPage(currentPage, pageSize);
//    }

    @GetMapping("/{currentPage}/{pageSize}")
    public IPage<Book> getPage2(@PathVariable int currentPage, @PathVariable int pageSize) {
        System.out.println("getPage2...");

        Page<Book> page = new Page<>(currentPage, pageSize);
        return bookService.page(page);
    }
}
