package com.cho1r.polymorphicParameter;

/**
 * Author cho1r
 * 2021/12/12 下午 06:23
 */
public class Employee {
    private String name;
    private int sal;

    public Employee(String name, int sal) {
        this.name = name;
        this.sal = sal;
    }

    public int getAnnual() {
        return sal * 12;
    }
}
