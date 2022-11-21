package com.cho1r.homework.hw13;

/**
 * Author cho1r
 * 2021/12/14 下午 06:42
 */
public class Student extends Person {
    private String id;

    public Student(String name, char sex, int age, String id) {
        super(name, sex, age);
        this.id = id;
    }

    public void study() {
        System.out.println("hard studying.");
    }

    @Override
    public String play() {
        return super.play() + "soccer.";
    }

    public void printInfo() {
        System.out.println("student info:\n" + super.basicInfo());
        System.out.println("id: " + id);
        study();
        System.out.println(play());
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                ", id='" + id + '\'' +
                '}';
    }
}
