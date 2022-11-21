package com.cho1r.controller;

import com.cho1r.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author cho1r
 * 16/2/2022 下午7:27
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public Book getById() {
        System.out.println("getById is running...");

        Book book = new Book();
        book.setId(1);
        book.setName("springboot");
        book.setType("springboot");
        book.setDescription("springboot");

        return book;
    }
}
