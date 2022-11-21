package com.cho1r.final_;

/**
 * Author cho1r
 * 2021/12/16 下午 07:34
 */
public class FinalExercise {
    public static void main(String[] args) {

    }
}

class Cal {
    private double radius;
//    private final double PI = 3.14;// 1
    private final double PI;

    {
//        PI = 3.14;// 2
    }

    public Cal(double PI) {
        this.PI = PI;// 3
    }
}