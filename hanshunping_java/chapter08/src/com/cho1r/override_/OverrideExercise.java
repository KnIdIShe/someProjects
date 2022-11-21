package com.cho1r.override_;

/**
 * Author cho1r
 * 2021/12/10 下午 07:11
 */
public class OverrideExercise {
    public static void main(String[] args) {
        System.out.println(new Person("tom", 10).say());
        System.out.println(new Student("jerry", 12, 1, 56).say());
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String say() {
        return "name='" + name + '\'' +
                ", age=" + age;
    }
}

class Student extends Person {
    private int id;
    private int score;

    public Student(String name, int age, int id, int score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    @Override
    public String say() {
        return super.say() +
                ", id=" + id +
                ", score=" + score;
    }
}