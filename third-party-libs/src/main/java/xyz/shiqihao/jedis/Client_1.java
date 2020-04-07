package xyz.shiqihao.jedis;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * set/get: string-string
 */
public class Client_1 {
    private static final JedisPool POOL = new JedisPool();

    public static void main(String[] args) {
        User user = new User("sqh", 22, "sqh1107@gmail.com");
        String userJson = new Gson().toJson(user);
        Jedis jedis = POOL.getResource();
        jedis.set("sqh", userJson);
        System.out.println("I'm: " + jedis.get("sqh"));
    }
}
