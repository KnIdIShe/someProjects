package com.yakumo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * Author cho1r
 * 17/1/2022 上午9:37
 */
public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("---------------doGet--------------");
        System.out.println("username: " + req.getParameter("username"));
        System.out.println("password: " + req.getParameter("password"));
//        System.out.println("hobby: " + req.getParameter("hobby"));
        System.out.println("hobby: " + Arrays.toString(req.getParameterValues("hobby")));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("password: " + req.getParameter("password"));

        // 设置请求体字符集, 解决中文乱码, 需在获取参数之前调用
        req.setCharacterEncoding("UTF-8");

        System.out.println("---------------doPost--------------");
        System.out.println("username: " + req.getParameter("username"));
//        System.out.println("hobby: " + req.getParameter("hobby"));
        System.out.println("hobby: " + Arrays.toString(req.getParameterValues("hobby")));
    }
}
