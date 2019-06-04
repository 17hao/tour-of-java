package etc.designpattern;

/**
 * Singleton mode
 * Thread safe
 * When a thread enters the method, other threads trying to enter must wait even
 * if the class has been instantiation.
 * Not recommend
 */
public class SingletonLazySafe {
    private static SingletonLazySafe uniqueInstance;

    private SingletonLazySafe() {
    }

    public static synchronized SingletonLazySafe getUniqueInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new SingletonLazySafe();
        return uniqueInstance;
    }

    public static void main(String[] args) {
        SingletonLazySafe s = getUniqueInstance();
        System.out.println(s);
    }
}
