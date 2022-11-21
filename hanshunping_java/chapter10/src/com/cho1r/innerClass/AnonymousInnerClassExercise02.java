package com.cho1r.innerClass;

/**
 * Author cho1r
 * 2021/12/17 下午 07:50
 */
public class AnonymousInnerClassExercise02 {
    public static void main(String[] args) {
        alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("起床了!, 快!");
            }
        });

        alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("上课了.");
            }
        });
    }

    public static void alarmClock(Bell bell) {
        bell.ring();
    }
}

interface Bell {
    void ring();
}
