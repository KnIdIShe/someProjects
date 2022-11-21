package com.yakumo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yakumo.domain.Book;
import com.yakumo.service.IBookService;
import com.yakumo.utils.R;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Author cho1r
 * 13/2/2022 下午1:25
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {
        List<Book> data = bookService.list();
        return new R(data);
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
//        R r = new R();
//        r.setFlag(bookService.save(book));
//        return r;

        if (book.getName().equals("123")) {
            throw new IOException();
        }
        boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功😊" : "添加失败😒");
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        boolean flag = bookService.updateById(book);
        return new R(flag);
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable long id) {
        boolean flag = bookService.removeById(id);
        return new R(flag);
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable long id) {
        Book data = bookService.getById(id);
        return new R(data);
    }

//    @GetMapping("/{currentPage}/{pageSize}")
//    public IPage<Book> getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
//        return bookService.getPage(currentPage, pageSize);
//    }

//    @GetMapping("/{currentPage}/{pageSize}")
//    public R getPage2(@PathVariable int currentPage, @PathVariable int pageSize) {
//        IPage<Book> page = new Page<>(currentPage, pageSize);
//
//        IPage<Book> data = bookService.page(page);
//        // 如果查询的页数 > 数据库总页数, 按查询数据库最后一页
//        if (currentPage > data.getPages()) {
//            page.setCurrent(data.getPages());
//            data = bookService.page(page);
//        }
//
//        return new R(data);
//    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage2(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
        IPage<Book> page = new Page<>(currentPage, pageSize);

        // 条件查询
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());

        IPage<Book> data = bookService.page(page, lqw);

        // 如果查询的页数 > 数据库总页数, 按查询数据库最后一页
        if (currentPage > data.getPages()) {
            page.setCurrent(data.getPages());
            data = bookService.page(page, lqw);
        }

        return new R(data);
    }
}
