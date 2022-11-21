package com.cho1r.homework.hw13;

/**
 * Author cho1r
 * 2021/12/14 下午 06:44
 */
public class Person {
    private String name;
    private char sex;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String play() {
        return name + " like play ";
    }

    public String basicInfo() {
        return String.format("name: %s\nsex: %s\nage: %s", name, sex, age);
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age
                ;
    }
}
