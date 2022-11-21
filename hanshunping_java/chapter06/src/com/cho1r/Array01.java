package com.cho1r;

/**
 * Author cho1r
 * 2021-11-30 030 03:23 下午
 */
public class Array01 {
    public static void main(String[] args) {
        double[] hens = {3, 5, 1, 3.4, 2, 50};
        int len = hens.length;
        double sum = 0;
        for (int i = 0; i < len; i++) {
            sum += hens[i];
        }
        double avg = sum / hens.length;

        System.out.println("total: " + sum + " avg " + avg);
    }
}
