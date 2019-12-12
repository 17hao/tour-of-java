package xyz.shiqihao.effectivejava.chap05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Item26_DoNotUseRawTypes {
    public static void main(String[] args) {
        // Raw collection type - don't do this!
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
