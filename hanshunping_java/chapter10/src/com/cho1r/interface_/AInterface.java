package com.cho1r.interface_;

/**
 * Author cho1r
 * 2021/12/17 下午 12:23
 */
public interface AInterface {
    // JDK8及以后
    // 默认实现方法
    default public void hi() {
        System.out.println("hi.");
    }

    // 静态方法
    public static void say() {
        System.out.println("say.");
    }

    // 接口中的方法默认是 public abstract, 所以可省略
    public abstract void hello();
}
