package xyz.shiqihao.netty.myexample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Classic ServerSocket Loop
 */
public class Server implements Runnable {
    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(80);
            while (!Thread.interrupted()) {
                new Thread(new Handler(ss.accept())).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Handler implements Runnable {
        final Socket s;

        Handler(Socket s) {
            this.s = s;
        }

        @Override
        public void run() {
            try {
                byte[] input = new byte[512];
                s.getInputStream().read(input);
                byte[] output = process(input);
                s.getOutputStream().write(output);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private byte[] process(byte[] arg) {
            return arg;
        }
    }
}
