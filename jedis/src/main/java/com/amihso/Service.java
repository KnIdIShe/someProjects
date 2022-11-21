package com.amihso;

import com.amihso.util.JedisUtils;
import redis.clients.jedis.Jedis;

/**
 * Author cho1r
 * 2022/02/23 17:57
 */
public class Service {

    private String id;
    private int num;

    public Service(String id, int num) {
        this.id = id;
        this.num = num;
    }

    // 控制单元
    public void service() {
//        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Jedis jedis = JedisUtils.getJedis();

        String key = "compid:" + id;
        String value = jedis.get(key);
        try {
            // 判断是否存在
            if (value == null) {
                // 不存在, 创建该值
                jedis.setex(key, 5, Long.MAX_VALUE - num + "");
            } else {
                // 存在, 自增, 调用业务
                Long time = jedis.incr(key);
                business(id, num - (Long.MAX_VALUE - time));
            }
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("VIP过期");
        } finally {
            jedis.close();
        }
    }

    // 业务操作
    public void business(String id, Long time) {
        System.out.println("用户 " + id + " 业务执行操作 " + time);
    }
}

class MyThread extends Thread {
    Service sc;

    public MyThread(String id, int num) {
        this.sc = new Service(id, num);
    }

    public void run() {
        while (true) {
            sc.service();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        MyThread mt = new MyThread("beginner", 10);
        MyThread mt2 = new MyThread("advanced", 30);
        mt.run();
        mt2.run();
    }
}