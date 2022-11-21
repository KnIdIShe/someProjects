package com.cho1r.homework;

/**
 * Author cho1r
 * 2021/12/14 上午 11:12
 */
public class hw04 {
    public static void main(String[] args) {
//        System.out.println(new Manager("tom", 200, 20, 1.2, 1000).sal());
        System.out.println(new Employee("jerry", 100, 20).sal());
    }
}

class Employee {
    private String name;
    private double dailySalary;
    private int workDays;
    private double grade = 1;

    public Employee(String name, double dailySalary, int workDays) {
        this.name = name;
        this.dailySalary = dailySalary;
        this.workDays = workDays;
    }

    public Employee(String name, double dailySalary, int workDays, double grade) {
        this.name = name;
        this.dailySalary = dailySalary;
        this.workDays = workDays;
        this.grade = grade;
    }

    public double sal() {
        return dailySalary * grade * workDays;
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, double dailySalary, int workDays, double grade, double bonus) {
        super(name, dailySalary, workDays, grade);
        this.bonus = bonus;
    }

    @Override
    public double sal() {
        return bonus + super.sal();
    }
}