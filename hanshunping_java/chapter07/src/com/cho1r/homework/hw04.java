package com.cho1r.homework;

import java.util.Arrays;

/**
 * Author cho1r
 * 2021/12/08 下午 04:07
 */
public class hw04 {
    public static void main(String[] args) {
        A04 a04 = new A04();
        System.out.println(Arrays.toString(a04.copyArr(new int[]{1, 2, 3, 5})));
    }
}

class A04 {
    public int[] copyArr(int[] arr) {
        int length = arr.length;
        int[] newArr = new int[length];
//
//        for (int i = 0; i < length; i++) {
//            newArr[i] = arr[i];
//        }

        System.arraycopy(arr, 0, newArr, 0, length);

        return newArr;
    }
}