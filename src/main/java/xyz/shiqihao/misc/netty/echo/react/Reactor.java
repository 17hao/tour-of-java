package xyz.shiqihao.misc.netty.echo.react;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * An echo server uses reactor pattern.
 */
class Reactor implements Runnable {

    private static final Logger logger = LogManager.getLogger();

    final Selector selector;
    final ServerSocketChannel serverSocket;

    public Reactor(int port) throws IOException {
        selector = Selector.open();
        serverSocket = ServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress(port));
        serverSocket.configureBlocking(false);
        SelectionKey sk = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        sk.attach(new Acceptor());
        logger.info("server started.");
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            for (final Iterator<SelectionKey> it = selector.selectedKeys().iterator(); it.hasNext(); it.remove()) {
                logger.info("next key: " + it.next());
                dispatch(it.next());
            }
        }
    }

    private void dispatch(SelectionKey key) {
        Runnable r = (Runnable) key.attachment();
        if (r != null) {
            r.run();
        }
    }

    private final class Acceptor implements Runnable {
        @Override
        public void run() {
            try {
                SocketChannel c = serverSocket.accept();
                if (c != null) {
                    new Handler(selector, c);
                }
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Reactor(9000).run();
    }
}