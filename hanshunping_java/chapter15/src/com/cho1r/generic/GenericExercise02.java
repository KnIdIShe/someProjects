package com.cho1r.generic;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Author cho1r
 * 2021-11-17 017 04:01 下午
 */
public class GenericExercise02 {
    public static void main(String[] args) {

        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("tom", 3000, new myDate(2012, 1, 2)));
        list.add(new Employee("tom", 3800, new myDate(2012, 1, 3)));
        list.add(new Employee("jerry", 3800, new myDate(2013, 1, 3)));
        list.add(new Employee("iris", 2800, new myDate(2014, 1, 4)));
//        list.add(null);

        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                // 名字不同, 比较名字
                if (!o1.getName().equals(o2.getName())) {
                    return o1.getName().compareTo(o2.getName());
                }
                // 名字相同比较生日
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });

        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
}

class Employee {
    private String name;
    private double sal;
    private myDate birthday;

    public String getName() {
        return name;
    }

    public myDate getBirthday() {
        return birthday;
    }

    public Employee(String name, int sal, myDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class myDate implements Comparable<myDate> {
    private int year;
    private int month;
    private int day;

    public myDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getFullBirthday() {
        return "" +
                year +
                (month < 10 ? "0" + month : month) +
                (day < 10 ? "0" + day : day);
    }

    @Override
    public String toString() {
        return "myDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(myDate o) {
        return this.getFullBirthday().compareTo(o.getFullBirthday());
    }
}