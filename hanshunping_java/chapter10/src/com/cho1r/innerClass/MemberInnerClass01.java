package com.cho1r.innerClass;

/**
 * Author cho1r
 * 2021/12/19 上午 09:14
 * 成员内部类
 */
public class MemberInnerClass01 {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
        outer01.new Inner01().m2();

        // 外部类访问内部类的方式
        // 1.
//        Outer01.Inner01 inner01 = outer01.new Inner01();
//        Outer01.Inner01 inner011 = new Outer01().new Inner01();
        // 2. 外部类方法返回内部类实例
//        Outer01.Inner01 inner01Instance = outer01.getInner01Instance();


    }
}

class Outer01 {
    private String name = "jerry";
    public int age;

    // 可添加访问修饰符, 同成员一样
    class Inner01 {
        private String name = "tom";

        public void m1() {
            System.out.println(name + ", " + age);
        }

        // 访问外部类重名属性
        public void m2() {
            System.out.println(name + ", " + Outer01.this.name);
        }
    }


    public void f1() {
        new Inner01().m1();
    }

    public Inner01 getInner01Instance() {
        return new Inner01();
    }

}