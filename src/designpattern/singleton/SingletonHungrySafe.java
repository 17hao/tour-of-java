package designpattern.singleton;

/**
 * Singleton mode
 * Thread safe
 * Created object at the beginning. But lost the advantage of lazy creating.
 */
class SingletonHungrySafe {
    private static SingletonHungrySafe uniqueInstance = new SingletonHungrySafe();

    private SingletonHungrySafe() {
    }

    static SingletonHungrySafe getUniqueInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new SingletonHungrySafe();
        return uniqueInstance;
    }

    @Override
    public String toString() {
        return "hungrySafe";
    }
}