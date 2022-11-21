package com.cho1r.innerClass;

/**
 * Author cho1r
 * 2021/12/17 下午 07:46
 */
public class AnonymousInnerClassExercise01 {
    public static void main(String[] args) {
        f1(new IB() {
            @Override
            public void show() {
                System.out.println("匿名内部类做实参.");
            }
        });
    }

    public static void f1(IB ib) {
        ib.show();
    }
}

interface IB {
    void show();
}