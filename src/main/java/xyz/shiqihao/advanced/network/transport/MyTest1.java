package xyz.shiqihao.advanced.network.transport;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * find the ports used.
 */
public class MyTest1 {
    public static void main(String[] args) {
        for (int i = 0; i < 65535; i++) {
            try {
                new ServerSocket(i);
            } catch (IOException e) {
                System.out.println("There is a server running on port: " + i);
            }
        }
    }
}
