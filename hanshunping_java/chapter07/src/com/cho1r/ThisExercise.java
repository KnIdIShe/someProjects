package com.cho1r;

/**
 * Author cho1r
 * 2021/12/08 上午 09:57
 */
public class ThisExercise {
    public static void main(String[] args) {
        Person p1 = new Person("tom", 12);
        Person p2 = new Person("tom", 12);
        System.out.println(p1.compareTo(p2));
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean compareTo(Person o) {
        return this.age == o.age && this.name.equals(o.name);
    }
}