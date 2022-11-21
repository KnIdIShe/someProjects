package com.amihso.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * Author cho1r
 * 2022/02/23 19:22
 */
public class JedisUtils {
    private static JedisPool jedisPool = null;
    private static String host = null;
    private static int port = 0;
    private static int maxTotal = 0;
    private static int maxIdle = 0;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("redis");
        host = bundle.getString("redis.host");
        port = Integer.parseInt(bundle.getString("redis.port"));
        maxTotal = Integer.parseInt(bundle.getString("redis.maxTotal"));
        maxIdle = Integer.parseInt(bundle.getString("redis.maxIdle"));

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        jedisPool = new JedisPool(config, host, port);
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();

    }
}
