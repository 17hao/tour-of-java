package designpattern.singleton;

/**
 * When SingletonInnerClass has been loaded, static inner class SingletonHolder
 * has't been loaded into memory. Only when 'getUniqueInstance' has been called,
 * SingletonHolder will be loaded. Initializing 'INSTANCE', JVM will ensure 'INSTANCE'
 * is only been initialized once.
 */
class SingletonInnerClass {
    private SingletonInnerClass() {
    }

    private static class SingletonHolder {
        private static final SingletonInnerClass INSTANCE = new SingletonInnerClass();
    }

    static SingletonInnerClass getUniqueInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public String toString() {
        return "innerClass";
    }
}
