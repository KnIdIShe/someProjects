package com.yakumo.controller;

import com.yakumo.exception.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author cho1r
 * 2022/01/11 下午 05:40
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws CustomException {
        System.out.println("testException 执行了..");

        try {
            // 模拟异常
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("自定义异常.");
        }

        return "success";
    }
}
