package com.cho1r;

import java.util.Arrays;

/**
 * Author cho1r
 * 2021/12/1 下午 04:08
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {2, 5, 3, 6, 8, 2, 3, 5, 7, 9};
        int[] arr = {2, 5, 6, 8, 9};

        int length = arr.length;
        int tmp, c = 0;
        boolean flag = false;
        to:
        for (int i = 0; i < length - 1; i++) {
            flag = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                    c++;
                    flag = true;
                }
            }
            // 如果一轮比较中没有一次交换, 则数组已经是升序的.
            if (flag = false) {
                break to;
            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(c);
    }
}
