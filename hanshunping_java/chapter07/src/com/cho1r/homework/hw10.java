package com.cho1r.homework;

/**
 * Author cho1r
 * 2021/12/08 下午 06:35
 */
public class hw10 {
    public static void main(String[] args) {

    }
}

class employee {
    private String name;
    private char sex;
    private int age;
    private String grade;
    private int sal;

    public employee(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public employee(String grade, int sal) {
        this.grade = grade;
        this.sal = sal;
    }

    public employee(String name, char sex, int age, String grade, int sal) {
        this(name, sex, age);
        this.grade = grade;
        this.sal = sal;

    }
}