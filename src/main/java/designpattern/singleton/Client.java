package designpattern.singleton;

public class Client {
    public static void main(String[] args) {
        SingletonLazyUnsafe lazyUnsafe = SingletonLazyUnsafe.getUniqueInstance();
        SingletonLazySafe lazySafe = SingletonLazySafe.getUniqueInstance();
        SingletonHungrySafe hungrySafe = SingletonHungrySafe.getUniqueInstance();
        SingletonInnerClass innerClass = SingletonInnerClass.getUniqueInstance();
        System.out.println(lazyUnsafe);
        System.out.println(lazySafe);
        System.out.println(hungrySafe);
        System.out.println(innerClass);
    }
}
