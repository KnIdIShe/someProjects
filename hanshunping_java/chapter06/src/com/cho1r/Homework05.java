package com.cho1r;

/**
 * Author cho1r
 * 2021/12/02 下午 02:05
 */
public class Homework05 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * 100 + 1);
        }

        // 逆序打印
        for (int i = length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int max = arr[0], index = 0, sum = arr[0];
        boolean flag = arr[0] == 8;
        for (int i = 1; i < length; i++) {
            sum += arr[i];
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
            if (arr[i] == 8) {
                flag = true;
            }
        }

        System.out.println(String.format("max: %s, index: %s, avg: %s", max, index, (double) sum / length));
        System.out.println("found it? " + flag);

    }
}
