package miscellaneous;

public class IfDemo {
    static int ifTest(int pre1, int pre2, int n) {
        if (n == 1)
            return pre1;
        if (n == 2)
            return pre2;
        else return ifTest(pre2, pre1 + pre2, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(ifTest(0, 1, 2));
    }
}
