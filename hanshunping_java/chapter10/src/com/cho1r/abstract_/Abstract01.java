package com.cho1r.abstract_;

/**
 * Author cho1r
 * 2021/12/17 上午 09:29
 */
public class Abstract01 {
    public static void main(String[] args) {

    }
}

abstract class Animal {
    private String name;
    public abstract void eat();

}

class Rabbit extends Animal{

    @Override
    public void eat() {
        System.out.println("rabbit eats carrot.");
    }
}