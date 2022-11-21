package com.cho1r;

/**
 * Author cho1r
 * 2021/12/1 下午 07:06
 */
public class TwoDimensionalArray02 {
    public static void main(String[] args) {
//        int[][] arr = new int[2][3];
        // or
        int[][] arr;
        arr = new int[2][3];

        arr[0][2] = 5;

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }
}
