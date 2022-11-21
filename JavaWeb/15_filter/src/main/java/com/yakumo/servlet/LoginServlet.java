package com.yakumo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author cho1r
 * 19/1/2022 下午3:13
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        resp.setContentType("text/html; charset=UTF-8");

        if ("tom".equals(username) && "123".equals(password)) {
            req.getSession().setAttribute("user", username);
            resp.getWriter().write("log succeed.");
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
