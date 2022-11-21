package com.cho1r;

/**
 * Author cho1r
 * 2021/12/06 上午 10:19
 * 斐波那契数列
 */
public class RecursionExercise01 {
    public static void main(String[] args) {
//        System.out.println(fibonacci(7));

        System.out.println(peach(9));
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static int peach(int n) {
        if (n == 10) {
            return 1;
        } else {
            return 2 * (peach(n + 1) + 1);
        }
    }
}
