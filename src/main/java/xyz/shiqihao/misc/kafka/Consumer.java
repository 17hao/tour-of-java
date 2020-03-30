package xyz.shiqihao.misc.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Consumer {
    private final static String TOPIC = "test";

    public static void main(String[] args) {
        Properties props = Configurations.consumer();
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            List<TopicPartition> topicPartitions = new ArrayList<>();
            List<PartitionInfo> partitions = consumer.partitionsFor(TOPIC);
            for (PartitionInfo info : partitions) {
                topicPartitions.add(new TopicPartition(TOPIC, info.partition()));
                System.out.println(String.format("partition: %d; leader: %s; topic: %s", info.partition(), info.leader(), info.topic()));
            }
            // consumer.subscribe(Collections.singletonList("test")); // 有自动再均衡的功能
            consumer.assign(topicPartitions);
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                System.out.println("count is: " + records.count());
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println(String.format("topic: %s; key/value: [%s : %s]; offset: %d", record.topic(),
                            record.key(), record.value(), record.offset()));
                    // consumer.commitSync();
                    System.out.println("Committed offset: " + consumer.committed(topicPartitions.get(0)).offset());
                    System.out.println("Position: " + consumer.position(topicPartitions.get(0)));
                }
            }
        }
    }
}
