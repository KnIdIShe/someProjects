package com.yakumo.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author cho1r
 * 16/1/2022 下午2:24
 */
public class ContextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletConfig().getServletContext();
        // 获取 context-param
        System.out.println(context.getInitParameter("username"));

        // 工程路径
        System.out.println(context.getContextPath());

        // 获取绝对路径, / 代表工程, 即 web目录
        System.out.println(context.getRealPath("/"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
