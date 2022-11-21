package com.cho1r;

/**
 * Author cho1r
 * 2021/12/06 下午 04:11
 */
public class HanoiTower {
    public static void main(String[] args) {
        move(2, 'a', 'b', 'c');
    }

    public static void move(int n, char a, char b, char c) {
        // 如果只剩一个盘, 则直接移动到 c
        if (n == 1) {
            System.out.println(a + " --> " + c);
        } else {
            // 先移动上面 n-1 个盘到 b
            move(n - 1, a, c, b);
            // 再移动最后一个盘到 c
            System.out.println(a + " --> " + c);
            // 再把 b 柱上 n-1个盘移动到 c
            move(n - 1, b, a, c);
        }
    }
}
