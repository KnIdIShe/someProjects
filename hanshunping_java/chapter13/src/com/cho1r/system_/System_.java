package com.cho1r.system_;

import java.util.Arrays;

/**
 * Author cho1r
 * 2021-11-29 029 05:53 下午
 */
public class System_ {
    public static void main(String[] args) {
//        System.out.println("ok1");
//        System.exit(0);
//        System.out.println("ok2");

        int[] src = {1, 2, 3};
        int[] dest = new int[3];
        System.out.println(Arrays.toString(dest));// [0, 0, 0]

        System.arraycopy(src, 0, dest, 0, src.length);
        System.out.println(Arrays.toString(dest));// [1, 2, 3]

        System.out.println(System.currentTimeMillis());

    }
}
