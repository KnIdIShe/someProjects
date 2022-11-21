package com.yakumo.controller;

import com.yakumo.domain.Account;
import com.yakumo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Author cho1r
 * 2022/01/10 下午 06:20
 * 请求参数的绑定
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    /**
     * 请求参数的绑定
     *
     * @param username
     * @return
     */
    @RequestMapping("testParam")
    public String testParam(String username) {
        System.out.println(username);
        return "success";
    }

    /**
     * 请求参数的绑定, form --> JavaBean
     *
     * @param
     * @return
     */
    @RequestMapping("saveAccount")
    public String saveAccount(Account account) {
        System.out.println(account);
        return "success";
    }

    /**
     * 请求参数的绑定, 自定义类型转换器
     *
     * @param
     * @return
     */
    @RequestMapping("saveUser")
    public String saveUser(User user) {
        System.out.println(user);
        return "success";
    }

    /**
     * Servlet 原生 API
     *
     * @param
     * @return
     */
    @RequestMapping("testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request);

        HttpSession session = request.getSession();
        System.out.println(session);

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        System.out.println(response);
        return "success";
    }
}
