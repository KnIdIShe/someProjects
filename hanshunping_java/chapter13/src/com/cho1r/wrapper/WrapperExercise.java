package com.cho1r.wrapper;

/**
 * Author cho1r
 * 2021-11-28 028 01:36 下午
 */
public class WrapperExercise {
    public static void main(String[] args) {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);// F

        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);// T

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);// F

        // == 一方有基本数据类型, 则比较值
        System.out.println(Integer.valueOf(127) == 127);
        System.out.println(Integer.valueOf(128) == 128);
    }
}
