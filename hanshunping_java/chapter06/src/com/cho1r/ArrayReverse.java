package com.cho1r;

import java.util.Arrays;

/**
 * Author cho1r
 * 2021/12/1 下午 12:32
 */
public class ArrayReverse {
    public static void main(String[] args) {
        reverse02();
    }

    // reverse type 2
    public static void reverse02() {
        int[] arr = {1, 3, 5, 32, 4, 6, 3};
        int length = arr.length;
        int[] arrNew = new int[length];
//        int last;
//        for (int i = 0; i < length; i++) {
//            last = length - 1 - i;
//            arrNew[i] = arr[last];
//        }

        for (int i = length - 1, j = 0; i >= 0; i--, j++) {
            arrNew[j] = arr[i];
        }

        arr = arrNew;
        arrNew = null;

        System.out.println(Arrays.toString(arr));
    }

    // reverse type 1
    public static void reverse01() {
        int[] arr = {1, 3, 5, 32, 4, 6, 3};
        int length = arr.length;
        int tmp, last, count = 0;
        // 交换次数
        int loop = length / 2;
        for (int i = 0; i < loop; i++) {
            // 后面元素的索引
            last = length - 1 - i;
            // change the index of two elements
            tmp = arr[i];
            arr[i] = arr[last];
            arr[last] = tmp;
            // 统计交换次数
            count++;
        }

        System.out.println(Arrays.toString(arr) + ", " + count);
    }
}
