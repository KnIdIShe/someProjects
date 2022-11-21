package com.yakumo.threadLocal;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author cho1r
 * 19/1/2022 下午6:34
 */
public class ThreadLocalTest {

    //    public static Map<String, Object> map = new ConcurrentHashMap<>();
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    private final static Random random = new Random();

    public static class Task implements Runnable {

        @Override
        public void run() {
            // 0 - 999
            int i = random.nextInt(1000);

            String name = Thread.currentThread().getName();
            System.out.println("线程[" + name + "] 生成的随机数是 " + i);
//            map.put(name, i);
            threadLocal.set(i);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            OrderService.createOrder();

//            System.out.println("线程[" + name + "] 即将结束前取出的数据是 " + map.get(name));
            System.out.println("线程[" + name + "] 即将结束前取出的数据是 " + threadLocal.get());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();
        }
    }
}
