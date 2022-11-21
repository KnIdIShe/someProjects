package com.cho1r.object_;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * Author cho1r
 * 2021/12/13 上午 10:03
 */
public class equals_ {
    public static void main(String[] args) throws InterruptedException {
        System.out.println( LocalDateTime.now());
        Thread.sleep(1000);
        System.out.println( LocalDateTime.now());

    }
}

class Person {
    private String name;
    private int age;
    private char sex;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && sex == person.sex && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }
}