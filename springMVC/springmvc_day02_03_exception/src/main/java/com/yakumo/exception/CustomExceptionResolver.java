package com.yakumo.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author cho1r
 * 12/1/2022 下午5:44
 * 异常处理器
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        // 获取异常
        CustomException ce = null;
        if (e instanceof CustomException) {
            ce = (CustomException) e;
        } else {
            ce = new CustomException("系统维护.");
        }

        // 创建 ModelAndView 对象
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg", e.getMessage());
        mv.setViewName("error");

        return mv;
    }
}
