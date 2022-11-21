package com.yakumo.exception;

/**
 * Author cho1r
 * 12/1/2022 下午5:38
 * 自定义异常类
 */
public class CustomException extends Exception {

    // 提示信息
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CustomException(String message) {
        this.message = message;
    }
}
