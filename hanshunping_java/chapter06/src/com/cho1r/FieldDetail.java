package com.cho1r;

/**
 * Author cho1r
 * 2021/12/02 下午 05:38
 */
public class FieldDetail {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.id);
        System.out.println(person.name);
        System.out.println(person.sal);
        System.out.println(person.isPass);
    }
}

class Person {
    String name;
    int id;
    double sal;
    boolean isPass;
}