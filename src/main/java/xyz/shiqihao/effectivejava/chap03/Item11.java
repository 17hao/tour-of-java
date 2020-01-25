package xyz.shiqihao.effectivejava.chap03;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Always override hashCode when you override equals.
 * <p>
 * ==比较的是2个对象的内存地址, equals方法比较的是2个对象在逻辑上的相同性.
 * 如果重写了一个类的equals方法, 并且该类的2个实例a.equals(b) == true,
 * 这2个对象从逻辑上来说是相同的. 如果不重写hashCode方法, 将这2个类作为
 * HashMap的key或HashSet的元素就会有问题. 因为这2个工具通过比较key的
 * hashCode来区分不同的元素. 以下的Person类说明了问题, 如果不重写hashCode,
 * HashMap或HashSet会认为同一个id和姓名的Person不是同一个人.
 */
public class Item11 {
    public static void main(String[] args) {
        Person p1 = new Person("1", "sqh");
        Person p2 = new Person("1", "sqh");
        System.out.println(p1.equals(p2));

        HashSet<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        System.out.println(set);

        HashMap<Person, Integer> map = new HashMap<>();
        map.put(p1, 1);
        System.out.println(map.get(new Person("1", "sqh")));
    }

    final static class Person {
        private final String id;
        private final String name;

        public Person(String id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int hashCode() {
            return id.hashCode() + name.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Person &&
                    id.equals(((Person) obj).id) &&
                    name.equals(((Person) obj).name);
        }
    }
}
