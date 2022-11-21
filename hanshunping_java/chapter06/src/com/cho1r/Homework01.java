package com.cho1r;

import java.util.Arrays;

/**
 * Author cho1r
 * 2021-11-30 030 06:16 下午
 */
public class Homework01 {
    public static void main(String[] args) {
        // question 1
//        char[] alpha = new char[26];
//        int len = alpha.length;
//        for (int i = 0; i < len; i++) {
//            alpha[i] = (char) ('A' + i);
//        }
//
//        System.out.println(Arrays.toString(alpha));

        // question 2
        int[] nums = {4, -1, 8, 10, 23};
        int max = nums[0], maxIndex = 0;
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        System.out.println(max + ", " + maxIndex);
    }
}
