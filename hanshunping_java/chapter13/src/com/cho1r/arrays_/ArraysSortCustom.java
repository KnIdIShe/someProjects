package com.cho1r.arrays_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Author cho1r
 * 2021-11-29 029 02:24 下午
 */
public class ArraysSortCustom {
    public static void main(String[] args) {
        Integer[] arr = {1, 3, -2, 0};
//        bubble01(arr);
//        bubble02(arr, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return (int) o2 - (int) o1;
//            }
//        });
//        System.out.println(Arrays.toString(arr));
//        Arrays.sort(arr);
//        int index = Arrays.binarySearch(arr, 1);
//        System.out.println(index);

//        Integer[] newArr = Arrays.copyOf(arr, arr.length);
//        System.out.println(Arrays.toString(newArr));

        // 填充, 相当于替换所有
        Arrays.fill(arr, 99);
        System.out.println(Arrays.toString(arr));

        // 是否所有元素相同
        System.out.println(Arrays.equals(arr, new Integer[]{1, 2, 3}));

        List<Integer> list = Arrays.asList(arr);// 编译类型 List
        System.out.println(list.getClass());// 运行类型 class java.util.Arrays$ArrayList
    }

    public static void bubble01(Integer[] arr) {
        int tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    // 定制排序
    public static void bubble02(Integer[] arr, Comparator c) {
        int tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (c.compare(arr[j],arr[j + 1]) > 0) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
