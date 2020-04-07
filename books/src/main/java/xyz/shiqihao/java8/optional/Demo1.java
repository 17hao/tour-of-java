package xyz.shiqihao.java8.optional;

import java.util.Optional;

public class Demo1 {
    private static class Person {
        String name;
        Optional<String> car;

        public Person(String name, String car) {
            this.name = name;
            this.car = Optional.ofNullable(car);
        }
    }

    public static void main(String[] args) {
        Person p = new Person("abc", "car");
        System.out.println(p.car.map(String::length));
    }
}


