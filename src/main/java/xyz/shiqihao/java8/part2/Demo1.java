package xyz.shiqihao.java8.part2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo1 {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );

        List<String> result = menu.stream()
                .filter (dish -> {
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
