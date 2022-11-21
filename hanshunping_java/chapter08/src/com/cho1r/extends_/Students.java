package com.cho1r.extends_;

/**
 * Author cho1r
 * 2021/12/09 下午 07:04
 */
public class Students {
    protected String name;
    protected int age;
    protected double score;

    public Students(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void info() {
        System.out.println("Students{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}');
    }
}
