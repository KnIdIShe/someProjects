package com.cho1r;

/**
 * Author cho1r
 * 2021/12/06 下午 06:53
 */
public class Overload_ {
    public static void main(String[] args) {
        myCal myCal = new myCal();
        System.out.println(myCal.cal(1, 2));
        System.out.println(myCal.cal(1, 2.3f));
    }
}

class myCal {
    public int cal(int n1, int n2) {
        return n1 + n2;
    }

    public double cal(int n1, double n2) {
        return n1 + n2;
    }

    public double cal(double n1, int n2) {
        return n1 + n2;
    }

    public int cal(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }
}