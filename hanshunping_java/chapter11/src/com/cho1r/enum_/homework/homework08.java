package com.cho1r.enum_.homework;

import java.security.PrivilegedAction;

/**
 * Author cho1r
 * 2021-11-25 025 06:18 下午
 */
public class homework08 {
    public static void main(String[] args) {
        Color.GREEN.show();

        switch (Color.YELLOW) {
            case GREEN -> System.out.println("get green.");
            default -> System.out.println("oops.");
        }
    }
}

interface IShow {
    void show();
}

enum Color implements IShow{
    RED(255, 0, 0),
    BLUE(0, 0, 255),
    BLACK(0, 0, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0);

    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }


    @Override
    public void show() {
        System.out.println("R: " + redValue + " G: " + greenValue + " B: " + blueValue);
    }
}