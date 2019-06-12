package thinkinginjava.chapter05_initialization;

/**
 * Simple use of the 'this' keyword
 * output: 3
 */
public class Leaf {
    private int i = 0;

    private Leaf increment() {
        ++i;
        return this;
    }

    private void print() {
        System.out.println(i);
    }

    public static void main(String[] args) {
        Leaf leaf = new Leaf();
        leaf.increment().increment().increment().print();
    }
}
