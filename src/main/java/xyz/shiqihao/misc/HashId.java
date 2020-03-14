package xyz.shiqihao.misc;

import org.hashids.Hashids;

public class HashId {
    public static void main(String[] args) {
        Hashids hashids = new Hashids("salt", 8);
        String hashedId = hashids.encode(1);
        System.out.println(hashedId);
    }
}
