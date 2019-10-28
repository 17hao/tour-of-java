package xyz.shiqihao.misc.network;

import java.io.IOException;
import java.net.ServerSocket;

public class LocalPortScanner {
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
