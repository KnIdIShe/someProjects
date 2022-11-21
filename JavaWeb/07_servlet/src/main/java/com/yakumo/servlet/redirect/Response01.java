package com.yakumo.servlet.redirect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author cho1r
 * 17/1/2022 下午6:05
 */
public class Response01 extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // 设置响应状态码
//        resp.setStatus(302);
//
//        // 不共享 request 域, 因为每次请求都是新的 request 域
//        req.setAttribute("key1", "value1");
//
//        // 设置响应头
////        resp.setHeader("Location", "http://localhost:8080/07_servlet_Web_exploded/response02");
//        // 不可访问 WEB-INF 目录
////        resp.setHeader("Location", "http://localhost:8080/07_servlet_Web_exploded/WEB-INF/form.html");
//        // 可访问项目外资源
//        resp.setHeader("Location", "https://www.bing.com");
//        // 必须加 协议://, 否则变成了资源路径: http://localhost:8080/07_servlet_Web_exploded/www.bing.com
////        resp.setHeader("Location", "www.bing.com");
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 方式2
        System.out.println("debug");
        resp.sendRedirect("https://www.bing.com");
    }
}
