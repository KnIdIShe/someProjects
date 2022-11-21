package com.cho1r.utils;

/**
 * Author cho1r
 * 2021/12/26 下午 03:19
 * 用于记录日志的工具类, 里面提供了公共的代码
 */
public class Logger {

    /**
     * 用于打印日志, 在切入点方法执行前执行
     */
    public void printLog() {
        System.out.println("已开始记录日志.");
    }
}
