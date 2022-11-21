package com.yakumo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author cho1r
 * 17/1/2022 下午3:16
 */
public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(resp.getCharacterEncoding());// ISO-8859-1
        // 设置服务器字符集
//        resp.setCharacterEncoding("UTF-8");
        // 通过响应头设置浏览器字符集
//        resp.setHeader("Content-Type", "text/html; Charset=UTF-8");

        // 同时设置服务器及浏览器字符集为 UTF-8, 也设置了响应头
        resp.setContentType("text/html; Charset=UTF-8");

        System.out.println(resp.getCharacterEncoding());

        PrintWriter writer = resp.getWriter();
        writer.write("好雨知時節.");
    }
}
