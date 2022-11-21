package com.cho1r;

/**
 * Author cho1r
 * 2021/12/02 下午 01:39
 */
public class Homework04_2 {
    public static void main(String[] args) {
        int[] arr = {10, 12, 45, 90};
        int add = 23;

        int[] arrNew = new int[arr.length + 1];
        int index = -1;

        // 找到插入的位置
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (arr[i] > add) {
                index = i;
                break;
            }
        }
        // 要添加的数大于所有的数, 则放至末尾
        if (index == -1) {
            index = length;
        }

        // 循环赋值
        int length1 = arrNew.length;
        // j 指向 arr
        for (int i = 0, j = 0; i < length1; i++) {
            if (i != index) {
                arrNew[i] = arr[j];
                j++;// 赋值后 j 指向 arr 的下一个元素
            } else {
                arrNew[i] = add;
            }
        }

        for (int j : arrNew) {
            System.out.print(j + " ");
        }
    }
}
