package com.cho1r;

/**
 * Author cho1r
 * 2021/12/09 下午 04:18
 */
public class Encapsulation01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("tom");
        person.setAge(214567);

        System.out.println(person.info());

        Person jerry = new Person("jerry", 1234);
        System.out.println(jerry.info());
    }
}

class Person {
    private String name;
    private int age;
    private int sal;
    private String job;

    public Person() {
    }

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 6) {
            this.name = name;
        } else {
            throw new RuntimeException("wrong name length.");
        }
    }

    public void setAge(int age) {
        if (1 <= age && age <= 120) {
            this.age = age;
        } else {
            this.age = 17;
        }
    }

    public String info() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sal=" + sal +
                ", job='" + job + '\'' +
                '}';
    }
}