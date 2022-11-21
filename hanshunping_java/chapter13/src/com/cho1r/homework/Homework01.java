package com.cho1r.homework;

import java.sql.Array;
import java.util.Arrays;

/**
 * Author cho1r
 * 2021-11-30 030 10:08 上午
 */
public class Homework01 {
    public static void main(String[] args) {
        System.out.println(reverse("h12345o", 2, 6));
    }

//    public static String reverse(String str, int start, int end) {
//        String head = str.substring(0, start - 1);
//        String tail = str.substring(end);
//
//        String body = str.substring(start - 1, end);
//        StringBuilder stringBuilder = new StringBuilder();
//        int len = body.length();
//        for (int i = len; i > 0; i--) {
//            // 逆序添加字符
//            stringBuilder.append(body.charAt(i - 1));
//        }
//        return stringBuilder.insert(0, head).append(tail).toString();
//
//    }

    public static String reverse(String str, int start, int end) {
        char[] array = str.toCharArray();
        char tmp;
        // 首尾依次交换
        for (int i = 0; i < (end - start) / 2; i++) {
            tmp = array[end - 1];
            array[end - 1] = array[start - 1];
            array[start - 1] = tmp;
            end--;
            start++;
        }
        return new String(array);
    }
}

