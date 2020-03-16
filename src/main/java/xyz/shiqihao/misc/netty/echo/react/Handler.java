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

    final SocketChannel c;
    final SelectionKey key;
    ByteBuffer buffer = ByteBuffer.allocate(1024);

    public Handler(Selector sel, SocketChannel c) throws IOException {
        this.c = c;
        c.configureBlocking(false);
        key = c.register(sel, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        logger.info("client connected: " + c);
    }

    void read() throws IOException {
        if (!buffer.hasRemaining()) {
            return;
        }
        c.read(buffer);
    }

    void process() {
        String s = new String(buffer.array(), 0, buffer.remaining());
        System.out.println("<=== " + s);
    }

    void write() throws IOException {
        buffer.flip();
        c.write(buffer);
        c.close();
    }

    @Override
    public void run() {
        try {
            read();
            process();
            write();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}