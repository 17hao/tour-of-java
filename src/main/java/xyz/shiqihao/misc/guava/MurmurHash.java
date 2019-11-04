package xyz.shiqihao.misc.guava;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public class MurmurHash {
    public static void main(String[] args) {
        Car myCar = new Car("v6", "black");
        int result = Math.abs(Hashing.murmur3_128().newHasher()
                .putString(myCar.engine(), Charsets.UTF_8)
                .putString(myCar.color(), Charsets.UTF_8)
                .hash()
                .asInt()) % 100;
        System.out.println(result);
    }
}

class Car {
    private final String engine;
    private final String color;

    Car(String engine, String color) {
        this.engine = engine;
        this.color = color;
    }

    String engine() {
        return engine;
    }

    String color() {
        return color;
    }
}
