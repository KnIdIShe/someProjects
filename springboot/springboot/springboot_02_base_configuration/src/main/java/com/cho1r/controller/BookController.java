package com.cho1r.controller;

import com.cho1r.MyDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author cho1r
 * 11/2/2022 下午1:49
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Value("${country}")
    private String country;

    @Value("${users.name}")
    private String name;

    @Value("${likes[2]}")
    private String like;

    @Value("${users2[1].name}")
    private String name2;

    @Value("${tmpDir}")
    private String tmpDir;

    @Autowired
    private Environment env;

    @Autowired
    private MyDataBase myDataBase;

    @GetMapping
    public String getById() {
        System.out.println("springboot is running...");
        System.out.println("country: " + country);
        System.out.println("user.name: " + name);
        System.out.println("user.name: " + like);
        System.out.println("user.name: " + name2);
        System.out.println("tmpDir: " + tmpDir);
        System.out.println("--------------------");
        System.out.println(env.getProperty("country"));
        System.out.println("--------------------");
        System.out.println(myDataBase);
        return "springboot is running...";
    }
}
