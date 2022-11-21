package com.cho1r.enum_.homework;

/**
 * Author cho1r
 * 2021-11-25 025 03:11 下午
 */
public class homework05 {
    public static void main(String[] args) {
        new A().f1();
    }
}

class A {
    private String NAME = "世界末日";

    public void f1() {
        class B {// 局部内部类
            private final String NAME = null;

            public void show() {
                System.out.println(NAME);
                System.out.println(A.this.NAME);// 访问外部类属性
            }
        }

        new B().show();
    }

}