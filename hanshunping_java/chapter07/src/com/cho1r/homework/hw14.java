package com.cho1r.homework;

import java.util.Random;

/**
 * Author cho1r
 * 2021/12/09 上午 10:11
 */
public class hw14 {
    public static void main(String[] args) {
        Tom tom = new Tom();
        tom.mora(0);
        tom.mora(1);
        tom.mora(2);
    }
}

class Tom {
    public void mora(int i) {
//        int j = (int) (Math.random() * 3);
        int j = new Random().nextInt(0,3);// [0, 3)

        if (i - j == -1 || i - j == 2) {
            System.out.println(i + "\t" + j + "\twin");
        } else if (i == j) {
            System.out.println(i + "\t" + j + "\tdraw");
        } else {
            System.out.println(i + "\t" + j + "\tlose");
        }
    }
}