package com.cho1r.arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author cho1r
 * 2021-11-29 029 12:58 下午
 */
public class ArraysMethod {
    public static void main(String[] args) {
        Integer[] arr = {1, 3, 5, 2};
        System.out.println(Arrays.toString(arr));// [1, 3, 5, 2]

        Arrays.sort(arr);// 数组地址引用, 会影响原数组
        System.out.println(Arrays.toString(arr));// [1, 2, 3, 5]

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });// [5, 3, 2, 1]

        System.out.println(Arrays.toString(arr));

    }
}
