package xyz.shiqihao.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 在这里探索一下Java是按引用传递还是按值传递
 */
public class PassByValue {
    public static void main(String[] args) {
        Dog myDog = new Dog("Mimi");
        Dog fooDog = foo(myDog);
        System.out.println(myDog == fooDog); // false

        String str = "";
        bar(str);
        System.out.println(str); // ""
    }

    /**
     * 考虑这个例子:
     * Dog myDog = new Dog("myD");
     * Dog fooDog = foo(myDog);
     * myDog是一个引用, 可以把它简单理解成一个内存地址类似于C的指针, 它指向真正的Dog对象(以下简记为outsideDog), 假设指向地址42.
     * 在这次调用foo(myDog))方法中, AAA行改变了对象outsideDog的名字;
     * BBB行实例化了一个新的对象(简记为insideDog), 假设存储在内存地址71这个位置.
     * 关键点在于myDog这个引用依旧指向outsideDog对象, 也就是地址42. 指向地址71上的对象的引用是fooDog. 假如传递给foo()的
     * 是outsideDog的引用(内存地址42), BBB行中这个引用指向的位置可以直接改变为insideDog的地址(71).
     * <p>
     * 在Java和C类似, 你可以申请一个指针, 并将指针传递给方法, 在方法中可以修改指针所指向位置上的内容,
     * 但是不能改变指针指向的位置. 也就是指针指向的内存空间中的数据被传递给被调用的方法并被修改了, 但是指针指向的位置无法被改变.
     */
    private static Dog foo(Dog fooD) {
        fooD.setName("fooDog"); // AAA
        fooD = new Dog("newDog"); // BBB
        fooD.setName("renameFooDog"); // CCC
        return fooD;
    }

    /**
     * 字符串对象创建过程: 首先在字符串常量池中寻找是否有已被创建的对象, 如果直接将引用指向该对象, 如果没新创建一个.
     * DDD行中创建了新的String对象. 传递进来的n的值为"", "name"在常量池中不存在. 新建一个对象. 但是调用bar()的main()
     * 中str指向的值并未被改变.
     */
    private static void bar(String n) {
        n = "name"; // DDD
    }

    private static List<List<Integer>> method1() {
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> l = new LinkedList<>();
        method2(l, ll, 3);
        return ll;
    }

    /**
     * 另一个有意思的例子, 证明Java的按值传递, 每次递归调用时, l一直会指向同一个对象, 只是会改变对象的值.
     * 所以如果想要每次递归调用时在ll中插入不同l的值, 要new一个新的List, ll.add(new ArrayList(l))
     */
    private static void method2(List<Integer> l, List<List<Integer>> ll, int count) {
        if (count == 0) {
            return;
        } else {
            // System.out.println("before add ll: " + ll);
            l.add(new Random().nextInt(10));
            //ll.add(l);
            ll.add(new ArrayList<>(l));
            // System.out.println("after add ll: " + ll);
            method2(l, ll, --count);
        }
    }
}

class Dog {
    private String name;

    Dog(String name) {
        this.name = name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}