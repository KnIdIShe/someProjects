package com.cho1r.homework;

/**
 * Author cho1r
 * 2021/12/08 上午 11:00
 */
public class hw01 {
    public static void main(String[] args) {
        A01 a01 = new A01();
//        System.out.println(a01.max(new int[]{1, 4, 5, 3, 8, 0}));
//        System.out.println(a01.max(new int[]{}));
        System.out.println(a01.max(null));
    }
}

class A01 {
    public int max(int[] arr) {
        if (arr == null) {
            throw new RuntimeException("arr 为 null.");
        }

        int length = arr.length;
        if (length == 0) {
            throw new RuntimeException("arr 内没有元素.");
        }

        int max = arr[0];
        for (int i = 1; i < length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }
}