package main.designpattern.singleton;

public class DoubleLocksSingleton {
    private DoubleLocksSingleton() {}

    private static DoubleLocksSingleton instance = null;

    static DoubleLocksSingleton getInstance(DoubleLocksSingleton instance) {
        if (instance == null) {
            synchronized (DoubleLocksSingleton.class) {
                if (instance == null) {
                    instance = new DoubleLocksSingleton();
                }
            }
        }
        return instance;
    }
}
