package xyz.shiqihao.designpattern.singleton;

/**
 * Singleton pattern
 * Thread unsafe
 * If multiple threads access field `uniqueInstance`, and `uniqueInstance` == null,
 * then multi object will be created.
 */
class SingletonLazyUnsafe {
    private static SingletonLazyUnsafe uniqueInstance;

    private SingletonLazyUnsafe() {
    }

    static SingletonLazyUnsafe getUniqueInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new SingletonLazyUnsafe();
        return uniqueInstance;
    }

    @Override
    public String toString() {
        return "lazyUnsafe";
    }
}
