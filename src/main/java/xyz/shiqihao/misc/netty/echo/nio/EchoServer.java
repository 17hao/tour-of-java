package xyz.shiqihao.misc.netty.echo.nio;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class EchoServer {
    private static final Logger logger = LogManager.getLogger();

    public void run() {
        try (
                final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                final Selector selector = Selector.open()
        ) {
            serverSocketChannel.bind(new InetSocketAddress(9000));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (!Thread.interrupted()) {
                if (selector.select(1000) == 0) {
                    continue;
                }
                for (final Iterator<SelectionKey> it = selector.selectedKeys().iterator(); it.hasNext(); it.remove()) {
                    final SelectionKey key = it.next();
                    if (key.isAcceptable()) {
                        accept(key);
                    }
                    if (key.isReadable()) {
                        read(key);
                    }
                    if (key.isWritable()) {
                        write(key);
                    }
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private void accept(SelectionKey key) throws IOException {
        final ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        final SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(key.selector(), SelectionKey.OP_READ | SelectionKey.OP_WRITE, ByteBuffer.allocate(1024));
        logger.info("client connected: " + socketChannel);
    }

    private void read(SelectionKey key) throws IOException {
        final SocketChannel socketChannel = (SocketChannel) key.channel();
        final ByteBuffer buffer = (ByteBuffer) key.attachment();
        final int read = socketChannel.read(buffer);
        if (read == -1) {
            return;
        }
        String content = new String(buffer.array(), 0, read).trim();
        logger.info("<===" + content);
    }

    private void write(SelectionKey key) throws IOException {
        final SocketChannel socketChannel = (SocketChannel) key.channel();
        final ByteBuffer buffer = (ByteBuffer) key.attachment();
        try {
            buffer.flip();
            if (!buffer.hasRemaining()) {
                return;
            }
            socketChannel.write(buffer);
        } finally {
            buffer.clear();
        }
        socketChannel.close();
    }

    public static void main(String[] args) {
        EchoServer server = new EchoServer();
        server.run();
    }
}
