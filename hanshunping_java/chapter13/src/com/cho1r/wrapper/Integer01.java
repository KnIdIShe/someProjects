package com.cho1r.wrapper;

/**
 * Author cho1r
 * 2021-11-28 028 12:48 下午
 */
public class Integer01 {
    public static void main(String[] args) {
        // jdk5 前
        // 手动装箱
        int i = 100;
        Integer integer = new Integer(i);
        Integer integer1 = Integer.valueOf(i);
        // 手动拆箱
        int i1 = integer.intValue();

        // jdk5 及以后, 自动装箱, 拆箱
        Integer integer2 = i;// 底层 Integer.valueOf(i), return new Integer(i)

        // 自动拆箱
        int i3 = integer2;// 底层 intValue()



        // test
        Double d = 100d;
        Float f = 1.5f;
        System.out.println(true ? new Integer(1) : new Double(2.0));// 三目运算符是一个整体, 会精度提升到Double级别
        System.out.println(new Integer(1));
    }
}
