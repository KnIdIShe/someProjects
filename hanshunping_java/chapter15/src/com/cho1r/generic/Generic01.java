package com.cho1r.generic;

import java.util.ArrayList;

/**
 * Author cho1r
 * 2021-11-16 016 06:57 下午
 */
public class Generic01 {
    public static void main(String[] args) {

        ArrayList<Dog> list = new ArrayList<>();
        list.add(new Dog("tom", 1));
        list.add(new Dog("jerry", 2));
        list.add(new Dog("iris", 3));

        for (Dog dog : list) {
            System.out.println(dog.getName() + ", " + dog.getAge());
        }
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}