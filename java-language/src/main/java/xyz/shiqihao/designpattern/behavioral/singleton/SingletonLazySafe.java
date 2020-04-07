package xyz.shiqihao.designpattern.behavioral.singleton;

/**
 * Singleton pattern
 * Thread safe
 * When a thread enters the method, other threads trying to enter must wait even
 * if the class has been instantiation.
 * Not recommend
 */
class SingletonLazySafe {
    private static SingletonLazySafe uniqueInstance;

    private SingletonLazySafe() {
    }

    static synchronized SingletonLazySafe getUniqueInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new SingletonLazySafe();
        return uniqueInstance;
    }

    @Override
    public String toString() {
        return "lazySafe";
    }
}
