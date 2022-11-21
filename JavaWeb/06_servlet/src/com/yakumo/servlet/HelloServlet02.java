package com.yakumo.servlet;

/**
 * Author cho1r
 * 16/1/2022 下午2:24
 */
public class HelloServlet02 extends HelloServlet{
    @Override
    public void doGet() {
        System.out.println("HelloServlet02 doGet");
    }

    @Override
    public void doPost() {
        System.out.println("HelloServlet02 doPost");
    }
}
