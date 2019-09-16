package main.etc.jedis;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisDemo {
    private static JedisPool pool = new JedisPool();

    public static void main(String[] args) {
        User user = new User("sqh", 22, "sqh1107@gmail.com");
        String userJson = new Gson().toJson(user);
        Jedis jedis = pool.getResource();
        jedis.set("sqh", userJson);
        jedis.hset("sqh", "","");
        String sqh = jedis.get("sqh");
        System.out.println(sqh);
    }
}
