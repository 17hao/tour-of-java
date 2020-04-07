package xyz.shiqihao.java8.datetime;

import java.time.ZoneId;

public class Demo6 {
    public static void main(String[] args) {
        ZoneId id = ZoneId.of("GMT+0800");
        System.out.println(id);
    }
}
