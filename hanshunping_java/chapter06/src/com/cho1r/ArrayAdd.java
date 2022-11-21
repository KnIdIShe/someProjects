package com.cho1r;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author cho1r
 * 2021/12/1 下午 02:00
 */
public class ArrayAdd {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            arr = add(arr, scanner);
            System.out.println(Arrays.toString(arr));
            while (true) {
                System.out.println("add again? y/n");
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

    public static int[] add(int[] arr, Scanner scanner) {
        int length = arr.length;
        int[] arrNew = new int[length + 1];
        for (int i = 0; i < length; i++) {
            arrNew[i] = arr[i];
        }

        System.out.println("plz input a num.");
        arrNew[length] = scanner.nextInt();

        System.out.println(Arrays.toString(arrNew));
        return arrNew;
    }
}
