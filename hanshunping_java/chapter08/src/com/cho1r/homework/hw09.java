package com.cho1r.homework;

/**
 * Author cho1r
 * 2021/12/14 下午 05:46
 */
public class hw09 {
    public static void main(String[] args) {

    }
}

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class LabeledPoint extends Point {
    private String color;

    public LabeledPoint(double x, double y, String color) {
        super(x, y);
        this.color = color;
    }
}