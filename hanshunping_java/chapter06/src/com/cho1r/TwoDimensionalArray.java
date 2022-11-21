package com.cho1r;

/**
 * Author cho1r
 * 2021/12/1 下午 06:48
 */
public class TwoDimensionalArray {
    public static void main(String[] args) {
        int[][] arr = {
                {
                        0, 0, 0, 0, 0
                },
                {
                        0, 1, 0, 0
                },
                {
                        0, 0, 1, 0, 0, 1
                },
                {
                        1, 0, 0, 0
                }
        };

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
