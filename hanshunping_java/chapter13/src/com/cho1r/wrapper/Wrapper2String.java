package com.cho1r.wrapper;

/**
 * Author cho1r
 * 2021-11-28 028 01:11 下午
 */
public class Wrapper2String {
    public static void main(String[] args) {
        // 包装类 --> String
        Integer i = 100;
        // 方式1
        String s = i + "";// 新对象指向 s, 不影响 i
        // 方式2
        String s1 = i.toString();
        // 方式3
        String s2 = String.valueOf(i);// 底层 obj.toString()

        // String --> 包装类
        String s3 = "12345";
        int i1 = Integer.parseInt(s3);

        Integer integer = new Integer(s3);
        Integer integer1 = Integer.valueOf(s3);
    }
}
