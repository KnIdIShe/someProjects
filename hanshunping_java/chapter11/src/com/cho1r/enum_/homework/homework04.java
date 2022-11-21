package com.cho1r.enum_.homework;

/**
 * Author cho1r
 * 2021-11-25 025 02:49 下午
 */
public class homework04 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();

        System.out.println(cellPhone.testWork(new ICal() {
            @Override
            public int work(int i, int j) {
                return i + j;
            }
        }, 1, 2));

        System.out.println(cellPhone.testWork(new ICal() {
            @Override
            public int work(int i, int j) {
                return i * j;
            }
        }, 10, 8));

    }
}

interface ICal {
    int work(int i, int j);
}

class CellPhone {
    public int testWork(ICal iCal, int i, int j) {// iCal 匿名内部类
        return iCal.work(i, j);
    }
}