package com.cho1r.homework;

/**
 * Author cho1r
 * 2021/12/08 下午 05:19
 */
public class hw06 {
    public static void main(String[] args) {
        Cal cal = new Cal(3, 0);
        System.out.println(cal.add());
        System.out.println(cal.subtract());
        System.out.println(cal.multiply());
        System.out.println(cal.divide());
    }
}

class Cal {
    private double m;
    private double n;

    public Cal(double m, double n) {
        this.m = m;
        this.n = n;
    }

    public double add() {
        return m + n;
    }

    public double subtract() {
        return m - n;
    }

    public double multiply() {
        return m * n;
    }

    public double divide() {
        if (n == 0) {
            throw new RuntimeException("除数不能为0.");
        }
        return m / n;
    }
}