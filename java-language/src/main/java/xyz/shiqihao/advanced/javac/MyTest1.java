package xyz.shiqihao.advanced.javac;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * From repository path:
 *
 * javac -cp /Users/17hao/.gradle/caches/modules-2/files-2.1/com.google.guava/guava/27.1-jre
 * /e47b59c893079b87743cdcfb6f17ca95c08c592c/guava-27.1-jre.jar src/main/java/xyz.shiqihao.advanced.javac.MyTest1.java -d .
 *
 * java -classpath .:/Users/17hao/.gradle/caches/modules-2/files-2.1/com.google.guava/guava/27.1-jre
 * /e47b59c893079b87743cdcfb6f17ca95c08c592c/guava-27.1-jre.jar  xyz.shiqihao.advanced.javac.MyTest1
 */
public class MyTest1 {
    public static void main(String[] args) {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(3, TimeUnit.HOURS)
                .concurrencyLevel(10)
                .build();
        cache.put("k", "v");
        System.out.println(cache.getIfPresent("k"));
    }
}
