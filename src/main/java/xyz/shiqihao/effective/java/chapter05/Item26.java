package xyz.shiqihao.effective.java.chapter05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 不要使用未带泛型类型的类.
 */
public class Item26 {
    public static void main(String[] args) {
        // Don't do this!
        final List stamp = new ArrayList();
        stamp.add(new Stamp());
        stamp.add(new Coin());
        for (Iterator i = stamp.iterator(); i.hasNext(); ) {
            Stamp s = (Stamp) i.next(); // Throws ClassCastException
        }

        final List<Stamp> stamps = new ArrayList<>();
    }
}

class Stamp {
}

class Coin {
}
