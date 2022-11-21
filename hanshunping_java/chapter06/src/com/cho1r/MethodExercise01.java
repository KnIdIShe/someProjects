package com.cho1r;

/**
 * Author cho1r
 * 2021/12/05 下午 01:03
 * 判断奇偶数
 */
public class MethodExercise01 {
    public static void main(String[] args) {
        AA aa = new AA();
        boolean odd = aa.isOdd(3);
        System.out.println(odd);

        aa.print(3, 4, '*');
    }
}

class AA {
    public boolean isOdd(int n) {
//        return n % 2 != 0 ? true : false;
        return n % 2 != 0;
    }

    public void print(int m, int n, char ch) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}