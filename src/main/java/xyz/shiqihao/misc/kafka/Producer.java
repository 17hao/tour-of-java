package xyz.shiqihao.misc.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {
    private static final String TOPIC = "test";

    public static void main(String[] args) {
        Properties props = Configurations.producer();
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, "country", "China");
        producer.send(record, (metadata, exception) -> {
            if (exception != null) {
                exception.printStackTrace();
            } else {
                System.out.println(metadata.topic() + "-" + metadata.partition() + ":" + metadata.offset());
            }
        });
        producer.close();
    }
}
