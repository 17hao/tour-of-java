package xyz.shiqihao.misc.netty.echo.react;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

final class Handler implements Runnable {
    private static final Logger logger = LogManager.getLogger();

    private final SelectionKey key;
    private ByteBuffer buffer = ByteBuffer.allocate(1024);

    Handler(Selector selector, SocketChannel c) throws IOException {
        c.configureBlocking(false);
        logger.info("client connected: " + c);

        key = c.register(selector, SelectionKey.OP_READ);
        key.attach(this);
    }

    @Override
    public void run() {
        try {
            SocketChannel client = (SocketChannel) key.channel();
            int read = client.read(buffer);
            logger.info("<=== " + new String(buffer.array(), 0, read).trim());
            if (new String(buffer.array()).trim().equals("close")) {
                client.close();
                logger.info("client closed connection.");
            }

            buffer.flip();
            client.write(buffer);
            buffer.clear();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}