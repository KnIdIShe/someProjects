package com.cho1r.innerClass;

/**
 * Author cho1r
 * 2021/12/19 上午 09:50
 */
public class StaticInnerClass01 {
    public static void main(String[] args) {
        // 外部类访问静态内部类, 静态属性, 直接访问(遵循访问权限)
        // 1.
//        new Outer02.Inner02().m1();

        // 2.通过方法返回内部类实例
//        new Outer02().getInner02Instance().m1();

        Outer02.Inner02 inner02 = new Outer02.Inner02();
        inner02.m2();

        // 访问静态属性的静态方法
        Outer02.Inner02.m3();
    }
}

class Outer02 {
    private static int n1;
    private String name;

    public void f1() {
        // 外部类访问静态内部类
        new Inner02().m1();
    }

    public Inner02 getInner02Instance() {
        return new Inner02();
    }

    static class Inner02 {
        private static int n1 = 999;

        public void m1() {
            // 可访问外部类所有静态成员
            System.out.println(n1);
        }

        // 访问与外部类重名属性
        public void m2() {
            System.out.println(n1 + ", " + Outer02.n1);
        }

        public static void m3() {
        }
    }
}