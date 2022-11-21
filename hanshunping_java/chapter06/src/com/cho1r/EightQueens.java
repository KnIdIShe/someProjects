package com.cho1r;

/**
 * Author cho1r
 * 2021/12/06 下午 06:07
 */
public class EightQueens {
    public static void main(String[] args) {
        // checkerboard
        int[][] arr = new int[8][8];

        int[] res = new int[8];


    }

    public static boolean eightQueens(int[][] arr, int x, int y, int[] res) {

        for (int i = 0; i < 8; i++) {
            if (arr[i][x] != 0 || arr[y][i] != 0) {
                return false;
            }
        }
    }

    public static boolean check() {

    }
}
