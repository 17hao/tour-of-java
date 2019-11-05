package xyz.shiqihao.misc.jedis;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * rpush/rpop: string-list
 */
public class Client_2 {
    private static final JedisPool POOL = new JedisPool();

    public static void main(String[] args) {
        Jedis jedis = POOL.getResource();
        List<Apple> inventory = Arrays.asList(new Apple("green", 10), new Apple("red", 11));
        List<String> l = serialize(inventory, a -> new Gson().toJson(a));
        jedis.rpush("apples", l.get(0), l.get(1));
        System.out.println("I have an apple: " + jedis.rpop("apples"));
    }

    private static List<String> serialize(List<Apple> inventory, Function<Apple, String> f) {
        List<String> result = new ArrayList<>();
        for (Apple a : inventory) {
            result.add(f.apply(a));
        }
        return result;
    }
}
