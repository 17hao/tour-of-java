package xyz.shiqihao.java8.stream;

import java.util.Comparator;
import java.util.Optional;

public class Demo5 {
    public static void main(String[] args) {
        Optional<Dish> maxCaloriesDish = Dish.menu.stream()
                .max(Comparator.comparing(Dish::calories));
        System.out.println(maxCaloriesDish.isPresent() ? maxCaloriesDish.get() : "nothing");
    }
}
