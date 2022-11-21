package com.cho1r.generic;

/**
 * Author cho1r
 * 2021-11-17 017 03:12 下午
 */
public class GenericDetail {
    public static void main(String[] args) {

        Pig<A> aPig = new Pig<>(new A());
        aPig.f();
        Pig<A> bPig = new Pig<>(new B());
        bPig.f();
    }
}

class A {}
class B extends A {}
class Pig<E> {
    private E e;

    public Pig(E e) {
        this.e = e;
    }

    public void f() {
        System.out.println(e.getClass());
    }
}