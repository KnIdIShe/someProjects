package com.cho1r.stringBuffer;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * Author cho1r
 * 2021-11-29 029 09:18 上午
 */
public class StringBufferExercise01 {
//    public static void main(String[] args) {
//        String name = "crash";
//        double price = 123456.34d;
//        String[] split = String.valueOf(price).split("\\.");
//
//        int loop;
//        // 判断循环次数(增加","的次数)
//        if (split[0].length() % 3 == 0) {
//            loop = split[0].length() / 3 - 1;
//        } else {
//            loop = split[0].length() / 3;
//        }
//
//        StringBuffer stringBuffer = new StringBuffer();
//        // 整数部分
//        String whole = split[0];
//        // 后三位
//        String last;
//        // 前面的部分
//        String before;
//
//        for (int i = 0; i < loop; i++) {
//            last = whole.substring(whole.length() - 3, whole.length());
//            before = whole.substring(0, whole.length() - 3);
//            whole = before;
//            stringBuffer.insert(0, last);
//            stringBuffer.insert(0, ",");
//        }
//        // 插入剩余的头部分
//        stringBuffer.insert(0, whole);
//        // 拼接小数点及小数部分
//        stringBuffer.append(".").append(split[1]);
//
//        System.out.println(stringBuffer);
//
//    }

    @Test
    public void format() {
        double price = 1234567.34d;
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(price));
        for (int i = stringBuffer.indexOf(".") - 3; i > 0; i -= 3) {
            stringBuffer.insert(i, ",");
        }
        System.out.println(stringBuffer);
    }
}
