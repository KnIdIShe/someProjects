package com.cho1r.abstract_;

/**
 * Author cho1r
 * 2021/12/17 上午 10:11
 */
public class AbstractExercise01 {
    public static void main(String[] args) {
        new Manager("tom", 1, 2300, 200).work();
    }
}

abstract class Employee {
    private String name;
    private int id;
    private double sal;

    public String getName() {
        return name;
    }

    public Employee(String name, int id, double sal) {
        this.name = name;
        this.id = id;
        this.sal = sal;
    }

    public abstract void work();
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, int id, double sal, double bonus) {
        super(name, id, sal);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("manager " + getName() + " is working.");
    }
}