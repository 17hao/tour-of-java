package miscellaneous;

public class ConstantPool {
    public static void main(String[] args) {
        Integer x = 127, y = 127;
        System.out.println(x == y); // true; same memory address
        x = 129;
        y = 129;
        System.out.println(x == y); // false; different memory address
    }
}
