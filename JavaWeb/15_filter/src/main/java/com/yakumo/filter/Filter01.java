package com.yakumo.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Author cho1r
 * 19/1/2022 下午5:44
 */
public class Filter01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter 1 前置代码");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filter 1 后置代码");
    }

    @Override
    public void destroy() {
    }
}
