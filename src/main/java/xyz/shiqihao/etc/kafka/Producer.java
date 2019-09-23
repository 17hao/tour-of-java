package xyz.shiqihao.etc.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {
    static private Properties kafkaProperties = new Properties();

    public static void main(String[] args) {
        kafkaProperties.put("bootstrap.servers", "localhost:9092");
        kafkaProperties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProperties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> producer = new KafkaProducer<>(kafkaProperties);
        ProducerRecord<String, String> record = new ProducerRecord<>("test", "country", "China");
        producer.send(record);
        producer.close();
    }
}
