package com.cho1r.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author cho1r
 * 11/2/2022 下午1:49
 */
@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public String getById() {
        System.out.println("springboot is running...2");

        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");

        return "springboot is running...2";
    }
}
