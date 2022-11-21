package com.yakumo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Author cho1r
 * 19/1/2022 下午1:35
 */
public class AdminFilter implements Filter {

    public AdminFilter() {
        System.out.println("1. constructor");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2. init");

        System.out.println("filter-name: " + filterConfig.getFilterName());
        System.out.println("filter-InitParameter: " + filterConfig.getInitParameter("username"));
        System.out.println("filter-ServletContext: " + filterConfig.getServletContext());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("3. doFilter");

        if (((HttpServletRequest) servletRequest).getSession().getAttribute("user") == null) {
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            return;
        } else {
            // 往下继续执行
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("4. destroy");
    }
}
