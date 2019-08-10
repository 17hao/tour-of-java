package miscellaneous;

public class Demo {
    private String str;
    private int i;

    private Demo(String str) {
        this.str = str;
    }

    public static void main(String[] args) {
        Demo demo = new Demo("initial");
        System.out.println(demo.str + " " + demo.i);
        demo.str = "string";
        System.out.println(demo.str + " " + demo.i);
    }
}
