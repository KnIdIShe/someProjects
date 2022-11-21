package com.cho1r.math;

/**
 * Author cho1r
 * 2021-11-29 029 11:24 上午
 */
public class MathMethod {
    public static void main(String[] args) {
        double v = Math.pow(2, 4);
        double ceil = Math.ceil(2.1);
        long round = Math.round(5.1);

        for (int i = 0; i < 10; i++) {
            // 2-7
//            System.out.println(Math.round(Math.random() * 5 + 2));
            System.out.println((int) (Math.random() * (7 - 2 + 1)) + 2);
        }
    }
}
