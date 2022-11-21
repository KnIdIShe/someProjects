package com.yakumo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Author cho1r
 * 2022/01/10 下午 02:23
 * 控制器类
 */
@Controller
@RequestMapping("/user")
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println("Hello, SpringMVC.");
        return "success";
    }

    @RequestMapping(value = "/testRequestMapping", params = {"username=hehe"}, headers = {"accept"})
    public String testRequestMapping() {
        System.out.println("testRequestMapping.");
        return "success";
    }
}
