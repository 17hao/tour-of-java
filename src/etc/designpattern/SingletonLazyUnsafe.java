package etc.designpattern;

/**
 * Singleton mode
 * Thread unsafe
 * If multiple threads access field uniqueInstance, and uniqueInstance == null,
 * then multi object will be created.
 */
public class SingletonLazyUnsafe {
    private static SingletonLazyUnsafe uniqueInstance;

    private SingletonLazyUnsafe() {
    }

    public static SingletonLazyUnsafe getUniqueInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new SingletonLazyUnsafe();
        return uniqueInstance;
    }

    public static void main(String[] args) {
        SingletonLazyUnsafe s = getUniqueInstance();
        System.out.println(s);
    }
}
