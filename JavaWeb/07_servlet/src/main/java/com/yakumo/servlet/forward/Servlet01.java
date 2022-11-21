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
public class Servlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 检查参数等工作
        System.out.println("servlet01 检查参数" + req.getParameter("username"));

        // 许可, 往 request 域中写入数据
        req.setAttribute("permit", "ok");

        // 转发
        req.getRequestDispatcher("/servlet02").forward(req, resp);
    }
}
