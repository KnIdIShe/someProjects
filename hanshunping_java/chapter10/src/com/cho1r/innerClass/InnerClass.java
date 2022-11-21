package com.cho1r.innerClass;

/**
 * Author cho1r
 * 2021/12/17 下午 06:13
 */
public class InnerClass {
}

class Outer {
    private int n1 = 100;

    public void m1() {
        class Inner {
            public void m2() {
                System.out.println(Outer.this.n1);

            }
        }
    }
}