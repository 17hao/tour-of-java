package xyz.shiqihao.java8.part_03.datetime;

import java.time.*;

public class Demo4 {
    public static void main(String[] args) {
        ZonedDateTime time = Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(time);
        LocalDateTime utcTime = Instant.now().atOffset(ZoneOffset.UTC).toLocalDateTime();
        System.out.println(utcTime);
    }
}
