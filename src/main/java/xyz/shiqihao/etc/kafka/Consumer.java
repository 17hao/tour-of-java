package xyz.shiqihao.etc.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;

import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class Consumer {
    static private Properties props = new Properties();

    public static void main(String[] args) {
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("group.id", "test");
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            List<PartitionInfo> partitionInfos = consumer.partitionsFor("test");
            for (PartitionInfo info : partitionInfos) {
                System.out.println("partition: " + info.partition() + ", leader: " + info.leader() + ", topic: " + info.topic());
            }
            consumer.subscribe(Collections.singletonList("test"));
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord record : records) {
                    System.out.println("topic: " + record.topic() + ", key: " + record.key() +
                            ", value: " + record.value() + ", offset: " + record.offset());
                }
            }
        }
    }
}
