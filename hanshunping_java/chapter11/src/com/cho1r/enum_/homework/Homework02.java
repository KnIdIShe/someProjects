package com.cho1r.enum_.homework;

/**
 * Author cho1r
 * 2021-11-25 025 12:59 下午
 */
public class Homework02 {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());

        System.out.println(new Frock().getSerialNum());
        System.out.println(new Frock().getSerialNum());
        System.out.println(new Frock().getSerialNum());
    }
}

class Frock {
    private static int currentNum = 100000;
    private int serialNum;

    public Frock() {
        serialNum = getNextNum();
    }

    public int getSerialNum() {
        return serialNum;
    }

    public static int getNextNum() {
        return currentNum += 100;
    }


}
