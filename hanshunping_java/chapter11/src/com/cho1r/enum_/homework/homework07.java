package com.cho1r.enum_.homework;

/**
 * Author cho1r
 * 2021-11-25 025 05:55 下午
 */
public class homework07 {
    public static void main(String[] args) {
        new Car(10).f1();
        new Car(44).f1();
        new Car(-12).f1();
    }
}

class Car {
    private int temperature;

    public Car(int temperature) {
        this.temperature = temperature;
    }

    class Air {
        public void flow() {
            if (temperature >= 40) {
                System.out.println("吹冷风.");
            } else if (temperature < 0) {
                System.out.println("吹暖气.");
            } else {
                System.out.println("空调关了.");
            }
        }
    }

    public void f1() {
        new Air().flow();
    }
}