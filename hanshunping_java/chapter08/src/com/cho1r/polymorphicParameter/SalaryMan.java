package com.cho1r.polymorphicParameter;

/**
 * Author cho1r
 * 2021/12/12 下午 06:25
 */
public class SalaryMan extends Employee{
    public SalaryMan(String name, int sal) {
        super(name, sal);
    }

    public void work() {
        System.out.println("salary man hard work.");
    }

}
