package xyz.shiqihao.misc.kafka;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;

import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Admin {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        AdminClient adminClient = AdminClient.create(properties);
        System.out.println(adminClient.listTopics().names().get());
        // System.out.println(adminClient.deleteConsumerGroups(Collections.singletonList("push-request-consumer")));
        System.out.println(adminClient.listConsumerGroups().all().get());
        System.out.println(adminClient.describeConsumerGroups(Collections.singletonList("push-result-consumer")).all().get());
        System.out.println(adminClient.describeTopics(Collections.singletonList("test")).all().get());
    }
}
