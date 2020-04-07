package xyz.shiqihao.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo0 {
    public static void main(String[] args) {
        List<Dish> menu = new ArrayList<>();
        menu.add(new Dish("c", false, 300, Dish.Type.FISH));
        menu.add(new Dish("d", false, 400, Dish.Type.MEAT));
        menu.add(new Dish("a", true, 500, Dish.Type.OTHER));
        List<String> lowCaloriesDish = menu.stream()
                .filter(dish -> dish.calories() < 400)
                .sorted(Comparator.comparing(Dish::calories))
                .map(Dish::name)
                .collect(Collectors.toList());
        for (String s : lowCaloriesDish) {
            System.out.println(s);
        }
    }
}
