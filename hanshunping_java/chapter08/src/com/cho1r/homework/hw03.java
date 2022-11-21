package com.cho1r.homework;

/**
 * Author cho1r
 * 2021/12/14 上午 10:56
 */
public class hw03 {
    public static void main(String[] args) {
        System.out.println(new AssociateProfessor("tom", 23, "一级教师", 2300).introduce());
    }
}

class Teacher {
    private String name;
    private int age;
    private String post;
    private double salary;

    public Teacher(String name, int age, String post, double salary) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
    }

    public String introduce() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", post='" + post + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class Professor extends Teacher {

    public Professor(String name, int age, String post, double salary) {
        super(name, age, post, salary * 1.3);
    }
}

class AssociateProfessor extends Teacher {

    public AssociateProfessor(String name, int age, String post, double salary) {
        super(name, age, post, salary * 1.2);
    }
}

class Lecturer extends Teacher {

    public Lecturer(String name, int age, String post, double salary) {
        super(name, age, post, salary * 1.1);
    }
}

