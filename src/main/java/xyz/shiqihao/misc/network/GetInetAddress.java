package xyz.shiqihao.misc.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetInetAddress {
    public static void main(String[] args) {
        try {
            System.out.println(InetAddress.getByName("shiqihao.xyz"));
            System.out.println(InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

