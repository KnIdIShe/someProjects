package com.cho1r.homework;

/**
 * Author cho1r
 * 2021/12/08 下午 03:16
 */
public class hw02 {
    public static void main(String[] args) {
        A02 a02 = new A02();
        System.out.println(a02.find(new String[]{"tom", "jerry"}, "haha"));
    }
}

class A02 {
    public int find(String[] arr, String str) {
        for (int i = 0; i < arr.length; i++) {
            if (str.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }
}