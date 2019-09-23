package main.thinkinginjava.chapter15_generics;

public class Holder2 {
    private Object a;

    private Holder2(Object a) {
        this.a = a;
    }

    private void set(Object a) {
        this.a = a;
    }

    private Object get() {
        return a;
    }

    public static void main(String[] args) {
        Holder2 h2 = new Holder2(new Automobile());
        Automobile a = (Automobile) h2.get();
        System.out.println(a);
        h2.set("not an automobile");
        String s = (String) h2.get();
        System.out.println(s);
        h2.set(1);
        Integer i = (Integer) h2.get();
        System.out.println(i);
    }
}
