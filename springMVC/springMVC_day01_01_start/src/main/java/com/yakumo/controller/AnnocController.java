package com.yakumo.controller;

import com.yakumo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * Author cho1r
 * 2022/01/11 下午 12:41
 * 常用注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes("msg")
public class AnnocController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username) {
        System.out.println("ok.");
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("ok.");
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable("sid") String id) {
        System.out.println("ok.");
        System.out.println(id);
        return "success";
    }

    /**
     * 获取请求头信息
     *
     * @param header
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader("accept") String header) {
        System.out.println("ok.");
        System.out.println(header);
        return "success";
    }

    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String cookieValue) {
        System.out.println("ok.");
        System.out.println(cookieValue);
        return "success";
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("default") User user) {
        System.out.println("ok.");
        System.out.println(user);
        return "success";
    }

    //    方式 2
    @ModelAttribute
    public void showUser(Map<String, User> map) {
        System.out.println("ModelAttribute");
        User user = new User();
        // 模拟数据库查询, 使其成为默认值
        user.setDate(new Date());

        map.put("default", user);
    }

//    方式 1
//    @ModelAttribute
//    public User showUser() {
//        System.out.println("ModelAttribute");
//        User user = new User();
//        // 模拟数据库查询, 使其成为默认值
//        user.setDate(new Date());
//
//        return user;
//    }

    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model) {
        System.out.println("ok.");
        model.addAttribute("msg", "get√");
        return "success";
    }

    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap) {
        System.out.println("ok.");
        System.out.println(modelMap.get("msg"));
        return "success";
    }

    @RequestMapping("/deleteSessionAttributes")
    public String deleteSessionAttributes(SessionStatus status) {
        System.out.println("ok.");
        status.setComplete();
        return "success";
    }
}
