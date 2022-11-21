package com.yakumo.servlet.forward;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author cho1r
 * 17/1/2022 上午10:46
 */
public class Servlet02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 检查参数等工作
        System.out.println("servlet02 检查参数" + req.getParameter("username"));

        // servlet02 处理自己的业务
        System.out.println("servlet02 处理自己的业务");
    }
}
