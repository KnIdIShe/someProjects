package com.cho1r.homework;

/**
 * Author cho1r
 * 2021/12/14 上午 09:05
 */
public class hw01 {
    public static void main(String[] args) {
        Person[] arr = {new Person("tom", 12, "cat"),
                new Person("jerry", 10, "mouse"),
                new Person("inu", 13, "dog"),
                new Person("iris", 23, "female")};

        int length = arr.length;
        // 排序
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                Person tmp = null;

                // 大到小
                if (arr[j].getAge() < arr[j + 1].getAge()) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        for (Person person : arr) {
            System.out.println(person);
        }
    }
}

class Person {
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}