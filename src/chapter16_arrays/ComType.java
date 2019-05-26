package chapter16_arrays;

import java.util.Arrays;

public class ComType implements Comparable<ComType> {
    private int i;
    private int j;
    private int count = 1;
    //private Random random = new Random(47);

    private ComType(int m, int n) {
        i = m;
        j = n;
    }

    @Override
    public String toString() {
        String result = "[i = " + i + " , j = " + j + "]";
        if (count++ % 3 == 0) {
            result += "\n";
        }
        return result;
    }

    @Override
    public int compareTo(ComType ct) {
        return (i < ct.j ? -1 : (i == ct.i ? 0 : -1));
    }

    public static void main(String[] args) {
        System.out.println("before sorting:");
        ComType ct1 = new ComType(58, 55);
        ComType ct2 = new ComType(93, 61);
        ComType[] array = {ct1, ct2};
        System.out.println(array.toString());
        Arrays.sort(array);
        System.out.println("after sorting:");
    }
}
