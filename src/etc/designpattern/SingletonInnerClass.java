package etc.designpattern;

/**
 * When SingletonInnerClass has been loaded, static inner class SingletonHolder
 * has't been loaded into memory. Only when 'getUniqueInstance' has been called,
 * SingletonHolder will be loaded. Initializing 'INSTANCE', JVM will ensure 'INSTANCE'
 * is only been initialized once.
 */
public class SingletonInnerClass {
    private SingletonInnerClass() {
    }

    private static class SingletonHolder {
        private static final SingletonInnerClass INSTANCE = new SingletonInnerClass();
    }

    public static SingletonInnerClass getUniqueInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        SingletonInnerClass s = getUniqueInstance();
        System.out.println(s);
    }
}
