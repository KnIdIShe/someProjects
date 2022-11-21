package com.cho1r.homework;

/**
 * Author cho1r
 * 2021/12/14 下午 01:16
 */
public class hw05 {
    public static void main(String[] args) {
        System.out.println(new Worker("tom", 2000).sal());
        System.out.println(new Teacherr("jerry", 1200, 20, 20).sal());
        System.out.println(new Scientist("iris", 3000, 1000).sal());
    }
}

class Employeee {
    private String name;
    private double sal;

    public Employeee(String name, double sal) {
        this.name = name;
        this.sal = sal;
    }

    public double sal() {
        return sal * 12;
    }
}

class Worker extends Employeee {

    public Worker(String name, double sal) {
        super(name, sal);
    }
}

class Teacherr extends Employeee {
    private double classSal;
    private int classDays;

    public Teacherr(String name, double sal, double classSal, int classDays) {
        super(name, sal);
        this.classSal = classSal;
        this.classDays = classDays;
    }

    @Override
    public double sal() {
        return super.sal() + classSal * classDays;
    }
}

class Scientist extends Employeee {
    private double bonus;

    public Scientist(String name, double sal, double bonus) {
        super(name, sal);
        this.bonus = bonus;
    }

    @Override
    public double sal() {
        return super.sal() + bonus;
    }
}