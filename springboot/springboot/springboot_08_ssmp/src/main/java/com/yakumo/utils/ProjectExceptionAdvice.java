package com.yakumo.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author cho1r
 * 14/2/2022 上午9:54
 * springmvc 的异常处理器
 */
//@ControllerAdvice
@RestControllerAdvice
public class ProjectExceptionAdvice {
    // 拦截所有异常信息
//    @ExceptionHandler(Exception.class) // 拦截具体异常
    @ExceptionHandler
    public R doException(Exception e) {
        // 记录日志
        // 通知运维
        // 通知开发
        e.printStackTrace();
        return new R(false, "服务器故障, 请稍后再试.");
    }
}
