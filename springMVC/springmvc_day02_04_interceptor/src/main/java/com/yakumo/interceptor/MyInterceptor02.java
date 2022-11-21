package com.yakumo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author cho1r
 * 12/1/2022 下午7:07
 */
public class MyInterceptor02 implements HandlerInterceptor {

    /**
     * controller 执行前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor02 preHandle 执行了.");
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
        return true;
    }

    /**
     * controller 执行后, success.jsp执行前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor02 postHandle 执行了.");
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor02 afterCompletion 执行了.");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
