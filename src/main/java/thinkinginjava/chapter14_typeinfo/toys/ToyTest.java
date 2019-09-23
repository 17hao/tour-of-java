package main.thinkinginjava.chapter14_typeinfo.toys;

public class ToyTest {
    private static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("main.thinkinginjava.chapter14_typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("FancyToy not found");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }
        Class up = c.getSuperclass();
        printInfo(up);
    }
}
