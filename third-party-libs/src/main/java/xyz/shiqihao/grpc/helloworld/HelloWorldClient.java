package xyz.shiqihao.grpc.helloworld;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import xyz.shiqihao.grpc.helloworld.HelloWorldProto.HelloReply;
import xyz.shiqihao.grpc.helloworld.HelloWorldProto.HelloRequest;
import xyz.shiqihao.grpc.helloworld.GreeterGrpc;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class HelloWorldClient {
    private static final Logger logger = Logger.getLogger(HelloWorldClient.class.getName());
    private final ManagedChannel channel;
    private final GreeterGrpc.GreeterFutureStub stub;

    private HelloWorldClient(ManagedChannel channel) {
        this.channel = channel;
        stub = GreeterGrpc.newFutureStub(channel);
    }

    private HelloWorldClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build());
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    private void greet(String name) {
        logger.info("Will try to greet " + name + "...");
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply response;
        try {
            logger.info("do something else...");
            Thread.sleep(3000);
            response = stub.sayHello(request).get();
        } catch (Exception e) {
            logger.warning("RPC failed");
            return;
        }
        logger.info("Greeting: " + response.getMessage());
    }

    public static void main(String[] args) throws InterruptedException {
        HelloWorldClient client = new HelloWorldClient("localhost", 50051);
        try {
            client.greet("sqh");
        } finally {
            client.shutdown();
        }
    }
}
