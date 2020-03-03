package xyz.shiqihao.misc.grpc.routeguide;

import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.shiqihao.misc.grpc.routeguide.RouteGuideGrpc.RouteGuideBlockingStub;
import xyz.shiqihao.misc.grpc.routeguide.RouteGuideGrpc.RouteGuideStub;
import xyz.shiqihao.misc.grpc.routeguide.RouteGuideGrpc;
import xyz.shiqihao.misc.grpc.routeguide.RouteGuideProto.*;

public class SimpleRouteGuideClient {
    private final Logger logger = LogManager.getLogger();

    private final RouteGuideBlockingStub blockingStub;
    private final RouteGuideStub asyncStub;

    public SimpleRouteGuideClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
    }

    public SimpleRouteGuideClient(ManagedChannelBuilder<?> managedChannelBuilder) {
        Channel channel = managedChannelBuilder.build();
        blockingStub = RouteGuideGrpc.newBlockingStub(channel);
        asyncStub = RouteGuideGrpc.newStub(channel);
    }

    public void getFeature() {
        Point request = Point.newBuilder().setLatitude(1).setLongitude(1).build();
        Feature feature;
        try {
            feature = blockingStub.getFeature(request);
            logger.info(feature);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public static void main(String[] args) {
        SimpleRouteGuideClient client = new SimpleRouteGuideClient("localhost", 9999);
        client.getFeature();
    }
}
