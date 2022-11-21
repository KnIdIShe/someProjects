package com.yakumo.threadLocal;

/**
 * Author cho1r
 * 19/1/2022 下午6:51
 */
public class OrderService {
    public static void createOrder() {
        String name = Thread.currentThread().getName();

//        System.out.println("OrderService 当前线程线程[" + name + "]中保存的数据是: " + ThreadLocalTest.map.get(name));

        System.out.println("OrderService 当前线程线程[" + name + "]中保存的数据是: " + ThreadLocalTest.threadLocal.get());
    }
}
