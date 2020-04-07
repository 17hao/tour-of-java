package xyz.shiqihao.effective.java.chapter09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 优先考虑使用for-each, 它不容易出错, 但是有些情况无法用, 比如要删除指定元素, 要替换一些元素.
 * for-each语句只能用在实现Iterable接口的类上, 所以对于自己的数据容器类尽量去实现这个接口.
 */
public class Item58 {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        // Not the best way to iterate over a collection
        for (Iterator<Integer> i = l.iterator(); i.hasNext(); ) {
            Integer n = i.next();
            System.out.println(n);
        }

        // Not the best way to iterate over an array
        int[] array = {1, 2, 3, 4};
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        for (Integer i : l) {
            System.out.println(i);
        }

        for (Integer i : array) {
            System.out.println(i);
        }
    }
}
