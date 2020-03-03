package xyz.shiqihao.misc.grpc.routeguide;

import xyz.shiqihao.misc.grpc.routeguide.RouteGuideProto.Feature;

/**
 * Common utilities for the RouteGuide demo.
 */
public class RouteGuideUtil {
    /**
     * Indicates whether the given feature exists (i.e. has a valid name).
     */
    public static boolean exists(Feature feature) {
        return feature != null && !feature.getName().isEmpty();
    }
}
