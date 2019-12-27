package xyz.shiqihao.advanced.netty.rownio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * A discard server implemented by java NIO api.
 */
public class DiscardServer {
    public static void main(String[] args) throws Exception {
        DiscardServer server = new DiscardServer();
        server.processConnection();
    }

    void processConnection() throws Exception {
        Selector selector = Selector.open();
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(6666));
        serverChannel.configureBlocking(false);
        serverChannel.register(selector, serverChannel.validOps());
        System.out.println("the server is running...");
        while (true) {
            selector.select();
            for (SelectionKey key : selector.selectedKeys()) {
                if (key.isAcceptable()) {
                    SocketChannel clientChannel = serverChannel.accept();
                    if (clientChannel != null) {
                        clientChannel.configureBlocking(false);
                        clientChannel.register(selector, clientChannel.validOps());
                        System.out.println("Connection accepted: " + clientChannel.getLocalAddress() + "\n");
                    }
                } else if (key.isReadable()) {
                    SocketChannel clientChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(64);
                    clientChannel.read(buffer);
                    String request = new String(buffer.array()).trim();
                    System.out.println(request);
                    if (request.equals("quit") || request.equals("exit")) {
                        clientChannel.close();
                    }
                }
            }
        }
    }
}
