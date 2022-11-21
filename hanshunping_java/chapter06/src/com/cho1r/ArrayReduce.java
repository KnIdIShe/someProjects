package com.cho1r;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author cho1r
 * 2021/12/1 下午 02:00
 */
public class ArrayReduce {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            arr = reduce(arr);
//            System.out.println(Arrays.toString(arr));
            while (true) {
                System.out.println("reduce again? y/n");
                String input = scanner.next();
                if (input.equals("n")) {
                    flag = false;
                    break;
                } else if (input.equals("y")) {
                    break;
                } else {
                    System.out.println("wrong input.");
                }
            }
        }

    }

    public static int[] reduce(int[] arr) {
        if (arr.length == 1) {
            throw new RuntimeException("数组长度为1, 不能删除.");
        }

        int length = arr.length - 1;

        int[] arrNew = new int[length];
        for (int i = 0; i < length; i++) {
            arrNew[i] = arr[i];
        }

        System.out.println(Arrays.toString(arrNew));
        return arrNew;
    }
}
