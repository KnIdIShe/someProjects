package com.cho1r.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * Author cho1r
 * 2021-11-16 016 07:47 下午
 */
public class GenericExercise {
    public static void main(String[] args) {

        HashMap<String, Person> map = new HashMap<>();
        map.put("stu1", new Person("tom", 12));
        map.put("stu2", new Person("jerry", 13));
        map.put("stu3", new Person("iris", 14));

        for (Map.Entry<String, Person> entry : map.entrySet()) {
            System.out.println(entry);
        }


    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
