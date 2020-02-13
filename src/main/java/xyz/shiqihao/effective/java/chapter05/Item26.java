package xyz.shiqihao.effective.java.chapter05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 什么是泛型? 泛型是一种限定参数类型的技术, 它通过编译时的类型检查来确保类型安全.
 * <p>
 * ① 如果有类型参数的类, 一定要使用类型参数, 不要使用原生的类.
 * ② 原生类型List意味着你可以插入多种类型, List<String>将容器内元素的类型限定为String.
 * ③ 如果还不确定元素的具体类型可以使用通配符List<?>, 但是一旦插入一个元素后, 容器内元素的类型
 * 就是确定的.
 * ④List<Object>意味着可以向这个容器插入Object的子类, 但是List<String>不是List<Object>的
 * 子类. 如果有一个方法, 它的参数是List<Object>, 可以向这个容器添加Integer, Long等等包装类,
 * 但是如果List<String>是List<Object>的子类, 它可以传递给这个方法, 但是它无法添加Object的其他子类.
 * <p>
 * 什么情况下类会使用类型参数? 这个类是一种容器, 装了另外一种类型, 比如容器类, Class类
 */
public class Item26 {
    public static void main(String[] args) {
        // Don't do this!
        final List stamp = new ArrayList();
        stamp.add(new Stamp());
        stamp.add(new Coin());
        for (Iterator i = stamp.iterator(); i.hasNext(); ) {
            Stamp s = (Stamp) i.next(); // Throws ClassCastException
        }

        final List<Stamp> stamps = new ArrayList<>();
    }

    static class Stamp {
    }

    static class Coin {
    }
}


