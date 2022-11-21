package com.yakumo.controller;

import com.yakumo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author cho1r
 * 2022/01/11 下午 05:40
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("执行了..");
        model.addAttribute("user", new User("tom", "123", 12));
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行了..");
        // 转发
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);

        // 重定向
//        response.sendRedirect(request.getContextPath() + "/index.jsp");

        // 直接响应
        // 设置中文编码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().println("你好, tom.");

        // 不执行后续代码
        return;
        // ...
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("执行了..");

        ModelAndView mv = new ModelAndView();
        // 存储导 mv 对象, 及 request 对象
        mv.addObject("user", new User("tom", "123", 12));
        // 跳转到哪个页面
        mv.setViewName("success");

        return mv;
    }

    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect() {
        System.out.println("执行了..");

        // 转发
//        return "forward:/WEB-INF/pages/success.jsp";

        // 重定向
        return "redirect:/index.jsp";
    }

    @RequestMapping("/testAjax")
    public @ResponseBody
    User testAjax(@RequestBody User user) {
        System.out.println("执行了..");
        System.out.println(user);


        return new User("jerry", "345", 11);
    }
}
