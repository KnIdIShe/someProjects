package com.cho1r;

/**
 * Author cho1r
 * 2021/12/08 上午 09:26
 */
public class ThisDetail {
    public static void main(String[] args) {
        new T();
    }
}

class T {
    public T() {
//        new T("tom");
        this("tom");
        System.out.println("T() 被调用.");
    }

    public T(String name) {
        System.out.println("T(String name) 被调用.");
    }

}