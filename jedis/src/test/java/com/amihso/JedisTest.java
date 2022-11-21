package com.amihso;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

/**
 * Author cho1r
 * 2022/02/23 15:48
 */
public class JedisTest {

    @Test
    public void testJedis() {
        // 1. 连接 redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 2. 操作 redis
        jedis.set("name", "tom");
        String name = jedis.get("name");
        System.out.println(name);
        // 3. 关闭连接
        jedis.close();
    }

    @Test
    public void testList() {
        // 1. 连接 redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 2. 操作 redis
        jedis.lpush("list1", "a", "b", "c");
        jedis.rpush("list1", "x");
        List<String> list = jedis.lrange("list1", 0, -1);
        list.forEach(System.out::println);
        // 3. 关闭连接
        jedis.close();
    }

    @Test
    public void testHash() {
        // 1. 连接 redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 2. 操作 redis
        jedis.hset("hash1", "a1", "a1");
        jedis.hset("hash1", "a2", "a2");
        jedis.hset("hash1", "a3", "a3");

        Map<String, String> hash = jedis.hgetAll("hash1");
//        hash.entrySet().forEach(System.out::println);
        System.out.println(hash);
        // 3. 关闭连接
        jedis.close();
    }
}
