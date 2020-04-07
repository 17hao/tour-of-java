package xyz.shiqihao.netty.echo.react;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

final class Handler implements Runnable {
    private static final Logger logger = LogManager.getLogger();

    private final SocketChannel c;
    private final SelectionKey key;
    private ByteBuffer buffer = ByteBuffer.allocate(1024);

    Handler(Selector selector, SocketChannel c) throws IOException {
        this.c = c;
        c.configureBlocking(false);
        logger.info("client connected: " + c);

        key = c.register(selector, SelectionKey.OP_READ);
        key.attach(this);
    }

    private int read() throws IOException {
        return c.read(buffer);
    }

    private void process(int readBytes) throws Exception {
        Thread.sleep(5000);
        String content = new String(buffer.array(), 0, readBytes).trim();
        logger.info("<=== " + content);
        if (content.equals("close")) {
            c.close();
        }
    }

    private void write() throws IOException {
        buffer.flip();
        c.write(buffer);
        buffer.clear();
    }

    @Override
    public void run() {
        try {
            int read = read();
            process(read);
            write();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }
}