package com.cho1r.static_;

/**
 * Author cho1r
 * 2021/12/15 下午 07:27
 */
public class ChildGame {
    public static void main(String[] args) {
        new Child("tom");
        new Child("jerry");

        System.out.println(Child.getCount());
    }
}

class Child {
    private String name;
    private static int count = 0;

    public Child(String name) {
        this.name = name;
        count++;
    }

    public static int getCount() {
        return count;
    }
}