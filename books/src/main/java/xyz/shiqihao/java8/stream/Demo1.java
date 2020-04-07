package xyz.shiqihao.java8.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Demo1 {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;

        List<String> result = menu.stream()
                .filter(dish -> {
                    System.out.println("filtering " + dish.name());
                    return dish.calories() < 400;
                })
                .map(d -> {
                    System.out.println("mapping " + d.name());
                    return d.name();
                })
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(result);
    }


}
