package com.cho1r.polymorphicParameter;

/**
 * Author cho1r
 * 2021/12/12 下午 06:27
 */
public class Manager extends Employee {
    private int bonus;

    public Manager(String name, int sal, int bonus) {
        super(name, sal);
        this.bonus = bonus;
    }

    public void manage() {
        System.out.println("manage salary man.");
    }

    @Override
    public int getAnnual() {
        return super.getAnnual() + bonus;
    }
}
