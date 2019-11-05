package xyz.shiqihao.misc.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;

/**
 * zadd/zrange/zrank
 */
public class Client_5 {
    private static final JedisPool POOL = new JedisPool();

    public static void main(String[] args) {
        Jedis jedis = POOL.getResource();
        Apple redApple = new Apple("red", 10);
        Apple greenApple = new Apple("green", 11);
        Map<String, Double> m = new HashMap<>();
        m.put(redApple.color(), (double) redApple.weight());
        m.put(greenApple.color(), (double) greenApple.weight());
        jedis.zadd("zset", m);
        System.out.println("zset: " + jedis.zrange("zset", 0, -1));
        System.out.println("rank of red apple: " + jedis.zrank("zset", redApple.color()));
        System.out.println("zset with sources: " + jedis.zrangeWithScores("zset", 0, -1));
    }
}
