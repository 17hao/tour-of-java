package xyz.shiqihao.misc.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Consumer {
    private final static String TOPIC = "test";

    public static void main(String[] args) {
        Properties props = initConf();
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            List<TopicPartition> partitions = new ArrayList<>();
            List<PartitionInfo> partitionInfos = consumer.partitionsFor(TOPIC);
            for (PartitionInfo info : partitionInfos) {
                partitions.add(new TopicPartition(TOPIC, info.partition()));
                System.out.println("partition: " + info.partition() + ", leader: " + info.leader() +
                        ", topic: " + info.topic());
            }
            // consumer.subscribe(Collections.singletonList("test")); // 有自动再均衡的功能
            consumer.assign(partitions);
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("topic: " + record.topic() + ", key: " + record.key() +
                            ", value: " + record.value() + ", offset: " + record.offset());
                }
            }
        }
    }

    private static Properties initConf() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test");
        return props;
    }
}
