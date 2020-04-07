package xyz.shiqihao.advanced.zerocopy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class TransferToServer {
    ServerSocketChannel listener;

    private void mySetup() {
        InetSocketAddress listenAdd = new InetSocketAddress(6688);
        try {
            listener = ServerSocketChannel.open();
            ServerSocket socket = listener.socket();
            socket.bind(listenAdd);
            System.out.println("Listening on port: " + listenAdd);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readData() {
        ByteBuffer dst = ByteBuffer.allocate(4096);
        try {
            while (true) {
                SocketChannel conn = listener.accept();
                conn.configureBlocking(true);
                int total = 0, i = 0;
                while (i != -1) {
                    i = conn.read(dst);
                    total = total + i;
                    dst.rewind();
                }
                System.out.println("Server receives " + total + " bytes from client.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TransferToServer server = new TransferToServer();
        server.mySetup();
        server.readData();
    }
}
