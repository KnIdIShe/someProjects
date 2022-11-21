package com.cho1r;

import java.util.Scanner;

/**
 * Author cho1r
 * 2021/12/1 下午 06:24
 */
public class SequenceSearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        Scanner scanner = new Scanner(System.in);
        System.out.println("plz input a num.");
        int input = scanner.nextInt();

        int l = arr.length;
        // 是否找到的标志
        boolean flag = false;
        for (int i = 0; i < l; i++) {
            if (arr[i] == input) {
                System.out.println("find it. the index is " + i);
                flag = true;
                break;
            }
        }
        if (flag == false) {
            System.out.println("oops..");
        }
    }
}
