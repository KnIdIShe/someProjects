package com.cho1r.static_;

/**
 * Author cho1r
 * 2021/12/16 下午 06:53
 */
public class SingleTon02 {
    public static void main(String[] args) {
        System.out.println(Cat.getInstance() == Cat.getInstance());
    }
}

class Cat {
    private Cat() {
    }

    private static Cat cat;

    public static Cat getInstance() {
        if (cat == null) {
            cat = new Cat();
        }
        return cat;
    }
}