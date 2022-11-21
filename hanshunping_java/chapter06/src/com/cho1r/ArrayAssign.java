package com.cho1r;

import java.util.Arrays;

/**
 * Author cho1r
 * 2021/12/1 上午 10:45
 */
public class ArrayAssign {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = n1;

        n2 = 80;// n1 照样等于10, 即基本数据类型+String 为值传递


        int[] arr1 = {1,2,3};
        int[] arr2 = arr1;// 引用传递, 传递的是地址

        arr2[0] = 10;
        System.out.println(Arrays.toString(arr1));// [10, 2, 3]
    }
}
