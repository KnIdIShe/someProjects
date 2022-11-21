package com.cho1r;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author cho1r
 * 2021-11-30 030 04:05 下午
 */
public class Array02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 动态初始化
        // type 1
//        int[] scores = new int[5];
        // type 2
        int[] scores;// 此时内存中没有分配空间
        scores = new int[5];// new 时才分配空间

        // 静态初始化
        int[] grades = {1, 2, 3, 4, 5};

        int len = scores.length;

        for (int i = 0; i < len; i++) {
            scores[i] = scanner.nextInt();
        }

        System.out.println(Arrays.toString(scores));
    }
}
