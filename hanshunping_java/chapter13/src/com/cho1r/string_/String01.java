package com.cho1r.string_;

import java.nio.charset.StandardCharsets;

/**
 * Author cho1r
 * 2021-11-28 028 03:06 下午
 */
public class String01 {
    public static void main(String[] args) {
//        final char[] value = {0, 1, 2};
//        value[0] = 1;
//
//        char[] v2 = {1, 1, 2};
        // final 数组不可指向新的地址, 但内容可更改
//        value = v2;

//        String s = "tom";
//        String s1 = new String("tom");
//        System.out.println(s.equals(s1));
//        System.out.println(s == s1);
//        System.out.println(s == s1.intern());
//        System.out.println(s1 == s1.intern());
//
//        System.out.println("tom" instanceof Object);
//
//        System.out.println("tom".intern());

        System.out.println("哈哈".length());// 字符数
        System.out.println("哈哈".getBytes(StandardCharsets.UTF_8).length);// 字节数
        System.out.println("asdsaklmdsa".substring(0, 5));// start end

        "tom".concat("jerry");
    }
}
