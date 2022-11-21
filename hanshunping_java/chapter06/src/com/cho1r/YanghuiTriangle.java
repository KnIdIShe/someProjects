package com.cho1r;

/**
 * Author cho1r
 * 2021/12/02 上午 09:41
 */
public class YanghuiTriangle {
    public static void main(String[] args) {
        int[][] arr = new int[10][];

        // type 1
//        arr[0] = new int[]{1};
//        arr[1] = new int[]{1, 1};
//        for (int i = 2; i < arr.length; i++) {
//            int[] ints = new int[i + 1];
//            ints[0] = 1;// 赋值第一个元素
//            ints[i] = 1;// 赋值最后一个元素
//            // 循环赋值中间的元素
//            for (int j = 1; j < i; j++) {
//                ints[j] = arr[i - 1][j - 1] + arr[i - 1][j];
//            }
//            arr[i] = ints;// 新建的数组赋给二维数组的当前行
//        }

        // type 2
        for (int i = 0; i < arr.length; i++) {
            int[] ints = new int[i + 1];

            // 循环赋值每行元素
            for (int j = 0; j < i + 1; j++) {// ints.length
                // 头尾元素
                if (j == 0 || j == i) {
                    ints[j] = 1;
                } else {
                    ints[j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }
            arr[i] = ints;// 新建的数组赋给二维数组的当前行
        }

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }

    }
}
