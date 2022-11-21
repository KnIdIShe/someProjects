package com.cho1r;

import java.util.Arrays;

/**
 * Author cho1r
 * 2021/12/1 上午 11:26
 */
public class ArrayCopy {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int length = arr1.length;

        int[] arr2 = new int[length];
        for (int i = 0; i < length; i++) {
            arr2[i] = arr1[i];
        }

        System.out.println(Arrays.toString(arr2));
        System.out.println(arr1 == arr2);
//        [1, 2, 3]
//        false
    }
}
