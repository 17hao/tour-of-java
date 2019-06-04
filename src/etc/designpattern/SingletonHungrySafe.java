package etc.designpattern;

/**
 * Singleton mode
 * Thread safe
 * Created object at the beginning. But lost the advantage of lazy creating.
 */
public class SingletonHungrySafe {
    private String mark;
    private static SingletonHungrySafe uniqueInstance = new SingletonHungrySafe("single");

    private SingletonHungrySafe(String mark) {
        this.mark = mark;
    }

    public static SingletonHungrySafe getUniqueInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new SingletonHungrySafe("double");
        return uniqueInstance;
    }

    public static void main(String[] args) {
        SingletonHungrySafe s = getUniqueInstance();
        System.out.println(s.mark);
    }
}
