package xyz.shiqihao.misc.roaringbitmap;

import org.roaringbitmap.RoaringBitmap;

public class Basic {
    public static void main(String[] args) {
        RoaringBitmap rr = RoaringBitmap.bitmapOf(1, 10, 1000, 10086);
        int cardinality = rr.getCardinality();
        System.out.println("cardinality is: " + cardinality);
        int size = rr.getSizeInBytes();
        System.out.println("size is: " + size);
        for (int i : rr) {
            System.out.println(i);
        }
    }
}
