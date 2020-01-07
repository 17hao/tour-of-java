package xyz.shiqihao.advanced.netty.nio;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * ServerSocketChannel and SocketChannel are alternatives to Java networking api.
 */
public class SimpleServer {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(9999));
        channel.configureBlocking(false);
        while (true) {
            SocketChannel socketChannel = channel.accept();
            if (socketChannel != null) {
                System.out.println("connect successfully...");
            }
        }
    }
}
