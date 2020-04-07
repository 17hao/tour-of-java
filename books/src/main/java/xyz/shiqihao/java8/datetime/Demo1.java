package xyz.shiqihao.java8.datetime;

import java.time.LocalDate;

public class Demo1 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2019, 11, 7);
        System.out.println(date);
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        System.out.println("year: " + year + " month: " + month + " day: " + day);
        System.out.println("Today is the " + date.getDayOfYear() + "th day of 2019");

        LocalDate d = LocalDate.    parse("2019-11-07");
        System.out.println(d);
    }
}
