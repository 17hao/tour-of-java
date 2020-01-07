package xyz.shiqihao.advanced.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * find the ip address of a host.
 */
public class MyTest1 {
    public static void main(String[] args) {
        try {
            System.out.println(InetAddress.getByName("shiqihao.xyz"));
            System.out.println(InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

