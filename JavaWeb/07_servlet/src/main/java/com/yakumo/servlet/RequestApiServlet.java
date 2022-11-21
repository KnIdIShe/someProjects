package com.yakumo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author cho1r
 * 16/1/2022 下午7:31
 */
public class RequestApiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("URI: " + req.getRequestURI());
        System.out.println("URL: " + req.getRequestURL());
        System.out.println("IP: " + req.getRemoteHost());
        System.out.println("请求头: " + req.getHeader("User-Agent"));
        System.out.println("请求方式: " + req.getMethod());

    }
}
