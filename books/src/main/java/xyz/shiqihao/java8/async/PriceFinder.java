package xyz.shiqihao.java8.async;

import java.util.List;

/**
 * Request every shop to get product price.
 * @param <String>
 */
@FunctionalInterface
interface PriceFinder<String> {
    List<String> findPrice(String product);
}
