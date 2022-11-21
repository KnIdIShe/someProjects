package com.cho1r;

import java.util.Arrays;

/**
 * Author cho1r
 * 2021/12/1 下午 02:58
 */
public class ArrayAddTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(arr));
        add(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void add(int[] arr) {
        arr[0] = 0;
    }
}
