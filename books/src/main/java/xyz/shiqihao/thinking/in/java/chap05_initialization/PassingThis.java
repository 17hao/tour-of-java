package xyz.shiqihao.thinking.in.java.chap05_initialization;

class Person {
    void eat(Apple apple) {
        Apple peeled = apple.getPeeled();
        System.out.println(peeled.toString() + " is yummy");
    }
}

class Peeler {
    static Apple peel(Apple apple) {
        // ... remove peel
        return apple; // Peeled
    }
}

class Apple {
    @Override
    public java.lang.String toString() {
        return "Apple";
    }

    Apple getPeeled() {
        return Peeler.peel(this);
    }
}


public class PassingThis {
    public static void main(String[] args) {
        new Person().eat(new Apple());
    }
}
