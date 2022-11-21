package com.cho1r;

/**
 * Author cho1r
 * 2021/12/1 下午 07:24
 */
public class TwoDimensionalArray03 {
    public static void main(String[] args) {
        int[][] arr = new int[3][];
        for (int i = 0; i < 3; i++) {
            arr[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = i + 1;
            }
        }

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        /**
         * 1
         * 2 2
         * 3 3 3
         */
    }
}
