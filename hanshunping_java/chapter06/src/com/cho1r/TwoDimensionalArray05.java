package com.cho1r;

/**
 * Author cho1r
 * 2021/12/02 上午 09:29
 */
public class TwoDimensionalArray05 {
    public static void main(String[] args) {
        int[][] arr = {{4, 6}, {1, 4, 5, 7}, {-2}};

        int sum = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }

        System.out.println(sum);
    }
}
