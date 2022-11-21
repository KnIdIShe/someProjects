package com.cho1r;

/**
 * Author cho1r
 * 2021/12/02 下午 12:10
 */
public class Homework04 {
    public static void main(String[] args) {
        int[] arr = {10, 12, 45, 90};
        int add = 45;

        int[] arrNew = new int[arr.length + 1];

        int i = 0;
        // 将 <= add的数组前半部分放入新数组
        while (arr[i] <= add) {
            arrNew[i] = arr[i];
            i++;
            // 防止下一轮while判断时数组越界抛出异常
            if (i >= arr.length) {
                break;
            }
        }

        i = arr.length - 1;
        // 将 >= add的数组后半部分放入新数组
        while (arr[i] > add) {
            arrNew[i + 1] = arr[i];
            i--;
            // 防止下一轮while判断时数组越界抛出异常
            if (i < 0) {
                break;
            }
        }

        // 新增的元素
        arrNew[i + 1] = add;

        for (int j : arrNew) {
            System.out.print(j + " ");
        }
    }
}
