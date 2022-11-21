package com.cho1r.innerClass;

/**
 * Author cho1r
 * 2021/12/17 下午 06:46
 * 匿名内部类
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        // 基于接口的匿名内部类
        IA ia = new IA() {
            @Override
            public void cry() {
                System.out.println("cry.");
            }
        };
        System.out.println(ia.getClass());

        ia.cry();
        ia.cry();
        ia.cry();

        // 基于类的匿名内部类
        Animal animal = new Animal() {
            @Override
            public void m1() {
                System.out.println("基于类的匿名内部类.");
            }
        };
        animal.m1();
        animal.m2("tom");
        System.out.println(animal.getClass());

    }
}

interface IA {
    void cry();
}

class Animal {
    public void m1() {
        System.out.println("m1()");
    }

    public void m2(String str) {
        System.out.println(str);
    }
}