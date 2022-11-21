package com.cho1r.homework;

/**
 * Author cho1r
 * 2021-11-30 030 02:14 下午
 */
public class Homework05 {
    public static void main(String[] args) {
        System.out.println(new A("tom").equals(new A("jerry")));// false, Object.equals(), 比较的是地址
    }
}

class A {
    private String name;

    public A(String name) {
        this.name = name;
    }
}