package xyz.shiqihao.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * sadd/spop/smembers
 */
public class Client_4 {
    private static final JedisPool POOL = new JedisPool();

    public static void main(String[] args) {
        Jedis jedis = POOL.getResource();
        jedis.sadd("set", "1", "2", "3");
        System.out.println(jedis.sadd("set", "3")); // output 0
        System.out.println(jedis.spop("set")); // remove random element
        System.out.println(jedis.smembers("set"));
    }
}
