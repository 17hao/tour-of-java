package xyz.shiqihao.java8.async;

import java.util.List;

@FunctionalInterface
interface PriceFinder<String> {
    List<String> findPrice(String product);
}
