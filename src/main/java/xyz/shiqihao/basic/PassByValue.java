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

        System.out.println("the dog is changed before foo(myDog)? " + !myDog.getName().equals("Mimi"));
        foo(myDog);
        System.out.println("the dog is changed after foo(myDog)? " + myDog.getName().equals("Mimi"));
        System.out.println("\n===\n");

        Dog barDog = bar(myDog);
        System.out.println("1) myDog still points to original object: " + myDog.getName().equals("barDog"));
        System.out.println("2) myDog points to the new Dog object instantiated in bar method: " + myDog.getName().equals("renameBarDog"));
        System.out.println("3) reference myDog and barDog are the same: " + (barDog == myDog));
        System.out.println("4) whether oldDog and the dog from bar(myDog) is the same dog: " + (myDog == barDog));
        System.out.println("\n===\n");

        System.out.println(method1());
    }

    /**
     * 考虑这个例子:
     * Dog d = new Dog("d");
     * Dog newD = bar(d);
     * d是一个引用, 可以把它简单理解成一个内存地址类似于C的指针, 它指向真正的Dog对象(以下简记为dog1), 假设指向地址42.
     * 在这次调用bar(d)方法中, AAA行真正改变了对象dog1的名字;
     * BBB行实例化了一个新的对象(简记为dog2), 假设存储在内存地71这个位置.
     * 关键点在于d这个引用依旧指向dog1对象, 也就是地址42. 指向地址71上的对象的引用是myDog.
     * 在Java和C中可以修改引用/指针指向的内存空间的值, 但是不能直接修改引用/指针的值.
     */
    private static Dog bar(Dog myDog) {
        myDog.setName("barDog"); // AAA
        myDog = new Dog("newDog"); // BBB
        myDog.setName("renameBarDog"); // CCC
        return myDog;
    }

    /**
     * 如果Java是按引用传递, DDD行代码会将传入方法的引用指向一个新的对象(新的内存地址).
     * 但是调用foo(Dog d)方法时传入的引用并没有被改变, 依旧指向旧的对象(旧的内存地址).
     * Java是按值传递的, 但是却传递了值的引用, 所以容易引起误解.
     */
    private static void foo(Dog d) {
        d = new Dog("Fifi"); // DDD
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