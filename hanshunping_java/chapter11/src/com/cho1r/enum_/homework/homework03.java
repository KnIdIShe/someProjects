package com.cho1r.enum_.homework;

/**
 * Author cho1r
 * 2021-11-25 025 02:38 下午
 */
public class homework03 {
    public static void main(String[] args) {
        new Cat().shot();
        new Dog().shot();
    }
}

abstract class Animal {
    public abstract void shot();
}

class Cat extends Animal {

    @Override
    public void shot() {
        System.out.println("小猫喵喵喵.");
    }
}

class Dog extends Animal {

    @Override
    public void shot() {
        System.out.println("小狗汪汪汪.");
    }
}