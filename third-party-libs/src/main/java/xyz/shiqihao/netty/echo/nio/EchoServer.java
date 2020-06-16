package xyz.shiqihao.netty.echo.nio;

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

/**
 * 传统的io操作模型是阻塞io, 不论是socket连接还是磁盘文件读取都是阻塞的,
 * 最简单的应对方式是创建多个线程或进程, 类似于众人拾柴火焰高, 但是缺点在于大量的进程和线程会消耗完资源.
 * 所以从节约资源的角度来看用单个进程或线程同时处理多个io更好.
 * linux有3个io多路复用的系统调用select/poll/epoll, 将待选择的文件描述符传递给内核, 让内核帮助应用程序在大量文件中挑选出能进行io操作的文件
 *
 * java nio的selector模型和io多路复用?
 * java nio需要基于这些系统调用吗?还是只是借用了io多路复用的模型?
 * netty的reactor模型和nio的selector模型和io多路复用异同?
 * 阻塞和非阻塞和io多路复用?
 *
 * 当使用bio的单线程模型时,客户端的连接会被阻塞,只有一个连接的请求能够被响应.
 * 当服务器和客户端建立连接后,服务器上的操作系统将数据从网络设备中拷贝到内核空间,
 * 网络设备数量是有限的,多个连接共享同一个网卡. socket是对网络连接的抽象, 应用程序
 * 在用户态,需要陷入内核态将网络设备上传来的数据拷贝到用户空间.
 * 阻塞I/O与非阻塞I/O发生在资源的请求阶段(包括磁盘,文件,CPU等), 阻塞意味着一次只能有一个
 * I/O请求获得资源, 哪怕这个请求只是占用了资源却不使用, 其他请求也必须排队等待. 非阻塞意味
 * 着在请求资源阶段不会持续等待,而是会不断进行轮询.
 * I/O多路复用模型:多个IO请求复用一个线程或进程,减少资源的消耗. 应用程序发起系统调用,检查是否有可用的
 * 设备,也就是检查文件描述符,操作系统遍历文件描述符,找到可用的文件描述符.
 * 异步IO:发出io请求后直接返回,请求结果由操作系统写入到缓冲区,应用程序读取缓冲区.
 * java nio使用了非阻塞IO和IO多路复用2者的结合,不论是bio还是nio都是同步的,也就是上一个请求
 * 处理完成后才能继续处理下一个.
 *
 * 单线程bio -> 多线程bio -> 单线程nio -> 多线程nio(多个逻辑处理线程 -> 多个)
 * 多线程bio对于每个请求创建一个新的线程,大量空闲的线程会浪费系统资源.
 * 多线程nio虽然也创建了多个线程,但是它和多线程bio的真正差别在于它不会为io操作创建线程,它是为逻辑处理的流程建立多个线程,所以系统中不会有
 * 空闲的多余线程,每个线程都尽可能地物尽其用进行逻辑处理. 这是最基础的reactor模型, io线程和分发逻辑处理都在同一个reactor角色中.
 * 当请求量非常大时(假设同时有1万个请求),一个reactor角色,也就是一个io线程会成为系统吞吐量的瓶颈,io线程为了给应用程序挑选出能读或写的通道耗时很久,
 * 所以为了增加吞吐量创建2个reactor,一个reactor负责io操作,当接收到io请求时将逻辑处理分发的任务给另一个reactor.
 */
public class EchoServer implements Runnable {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void run() {
        try (
                final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                final Selector selector = Selector.open()
        ) {
            serverSocketChannel.bind(new InetSocketAddress(9000));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            logger.info("Echo server started.");
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
                    if (key.isValid() && key.isWritable()) { // after returning from read(), the key is potentially canceled
                       write(key);
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e);
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
        if (content.equals("quit") || content.equals("exit")) {
            logger.info("client disconnected" + socketChannel);
            socketChannel.close();
            return;
        }
        logger.info("<===" + content);
    }

    private void write(SelectionKey key) throws Exception {
        final SocketChannel socketChannel = (SocketChannel) key.channel();
        final ByteBuffer buffer = (ByteBuffer) key.attachment();
        try {
            buffer.flip();
            if (!buffer.hasRemaining()) {
                return;
            }
            Thread.sleep(5000);
            socketChannel.write(buffer);
        } finally {
            buffer.clear();
        }
    }

    public static void main(String[] args) {
        EchoServer server = new EchoServer();
        server.run();
    }
}
