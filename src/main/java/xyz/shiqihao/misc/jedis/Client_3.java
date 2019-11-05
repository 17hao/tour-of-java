package xyz.shiqihao.misc.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * hset/hget: string-map
 */
public class Client_3 {
    private static final JedisPool POOL = new JedisPool();

    public static void main(String[] args) {
        Jedis jedis = POOL.getResource();
        Apple a = new Apple("red", 10);
        jedis.hset("red-apple", "color", a.color());
        System.out.println("color is: " + jedis.hget("red-apple", "color"));
    }
}
