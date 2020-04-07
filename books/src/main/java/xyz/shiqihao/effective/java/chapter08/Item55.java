package xyz.shiqihao.effective.java.chapter08;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Optional<T>使用的几点建议:
 * ① Optional<T>是一个容器, 它能存储具体的值和null. 所以不要在optional中再存放容器类型, 这会增加复杂性.
 * ② 不要用Optional包装基本数据类型的包装类, 会造成性能损失, 用OptionalInt等类.
 * ③ 对性能有极致追求的场景下, 直接返回null, 或者抛出异常会更好.
 */
public class Item55 {
    void method() {
        // Don't use an optional of a boxed primitive type.
        // Optional<Integer> oi = Optional.of(1);
        OptionalInt oi = OptionalInt.of(1);

        // Don't do this
        Optional<List<Integer>> oli = Optional.empty();
    }
}
