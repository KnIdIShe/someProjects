package com.cho1r.homework;

import javax.print.Doc;
import java.util.Objects;

/**
 * Author cho1r
 * 2021/12/14 下午 05:55
 */
public class hw10 {
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor("tom", 12, "cat", 'M', 2300);
        Doctor doctor3 = new Doctor("tom", 12, "cat", 'M', 2300);
        Doctor doctor2 = new Doctor("jerry", 13, "mouse", 'F', 1200);

        System.out.println(doctor1.equals(doctor3));
    }
}

class Doctor {
    private String name;
    private int age;
    private String job;
    private char gender;
    private double sal;

    public Doctor(String name, int age, String job, char gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return age == doctor.age && gender == doctor.gender && Double.compare(doctor.sal, sal) == 0 && Objects.equals(name, doctor.name) && Objects.equals(job, doctor.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, job, gender, sal);
    }
}