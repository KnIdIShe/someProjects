package com.cho1r.controller.bak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author cho1r
 * 11/2/2022 下午1:49
 */
//@RestController
@RequestMapping("/books")
public class BookController extends BaseClass {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

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
