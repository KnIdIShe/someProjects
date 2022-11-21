package com.yakumo.servlet;

import com.sun.corba.se.spi.activation.Server;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Author cho1r
 * 15/1/2022 下午6:30
 */
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("1. constructor");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2. init");
        System.out.println(servletConfig.getServletName());
        System.out.println(servletConfig.getInitParameter("username"));
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3. service hello servlet 被执行了.");

        // 类型转换, 调用 getMethod()
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        // 获取请求的方式
        String method = httpServletRequest.getMethod();

        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }
    }

    public void doGet() {
        System.out.println("many many get.");
    }

    public void doPost() {
        System.out.println("many many post.");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4. destroy");
    }
}
