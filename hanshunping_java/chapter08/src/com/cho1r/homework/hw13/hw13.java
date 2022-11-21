package com.cho1r.homework.hw13;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author cho1r
 * 2021/12/14 下午 06:42
 */
public class hw13 {
    public static void main(String[] args) {
        Student student = new Student("tom", 'M', 13, "12423426");
//        student.printInfo();

        print(student);

        Teacher teacher = new Teacher("jerry", 'M', 12, 5);
//        teacher.printInfo();

        print(teacher);

//        Person[] arr = {new Student("tom", 'M', 13, "12423426"),
//                new Student("tom", 'M', 15, "12423426"),
//                new Teacher("jerry", 'M', 12, 5),
//                new Teacher("jerry", 'M', 16, 5)
//        };
//
//        Arrays.sort(arr, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o2.getAge() - o1.getAge();
//            }
//        });
//
//        for (Person person : arr) {
//            System.out.println(person);
//        }

//        int[] arr = {1, 2, 3, 4, 5};
//        int length = arr.length;
//        int tmp = 0;
//        for (int i = 0; i < length - 1; i++) {
//            for (int j = 0; j < length - 1 - i; j++) {
//                // 效果相当于逆序
//                tmp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = tmp;
//            }
//        }
//        System.out.println(Arrays.toString(arr));


    }

    public static void print(Person person) {
        if (person instanceof Student) {
            ((Student) person).study();
        } else if (person instanceof Teacher) {
            ((Teacher) person).teach();
        }
    }
}
