package xyz.shiqihao.java8.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class Demo5 {
    public static void main(String[] args) throws ParseException {
        LocalDate now = LocalDate.now(ZoneId.of("GMT+11:00"));
        System.out.println(now.format(DateTimeFormatter.BASIC_ISO_DATE));

        LocalDate yesterday = LocalDate.now(ZoneId.of("GMT+11:00")).minusDays(1);
        System.out.println(yesterday.format(DateTimeFormatter.BASIC_ISO_DATE));

        LocalDate date = LocalDate.parse("20191217", DateTimeFormatter.BASIC_ISO_DATE.withZone(ZoneId.of("GMT+11:00")));
        System.out.println(date);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(ZoneId.of("GMT-11:00")));
        Date d = simpleDateFormat.parse("20191217");
        System.out.println(d.getTime());

        LocalDateTime l = LocalDateTime.parse("201912170000", DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
        System.out.println(l.atZone(ZoneId.of("GMT-11:00")));
    }
}