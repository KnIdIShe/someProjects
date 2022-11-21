package com.cho1r.polymorphicParameter;

/**
 * Author cho1r
 * 2021/12/12 下午 06:28
 */
public class test {
    public static void main(String[] args) {
//        Employee[] arr = {new Employee("tom", 100),
//                new SalaryMan("jerry", 200),
//                new Manager("kaka", 300, 10)};
//
//        for (Employee employee : arr) {
//            System.out.println(employee.getAnnual());
//            if (employee instanceof SalaryMan) {
//                ((SalaryMan) employee).work();
//            } else if (employee instanceof Manager) {
//                ((Manager) employee).manage();
//            }
//        }
//        int n = 5;
//        while (n-- != 0) {
//            System.out.println(n);
//        }

        Integer integer1 = new Integer(1000);
        Integer integer2 = new Integer(1000);

        System.out.println(integer1 == integer2);// false, 比较地址
        System.out.println(integer1.equals(integer2));// true, 比较值

        String str1 = new String("hello");
        String str2 = new String("hello");

        System.out.println(str1 == str2);// false, 比较地址
        System.out.println(str1.equals(str2));// true, 比较值



    }
}
