package xyz.shiqihao.java8.part_03.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class Demo3 {
    public static void main(String[] args) {
        Period p = Period.between(LocalDate.of(1996,11,7), LocalDate.now());
        System.out.println(p);
    }
}
