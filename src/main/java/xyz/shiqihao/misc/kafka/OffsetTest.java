package xyz.shiqihao.misc.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * lastConsumedOffset(最后消费位移) committedOffset(提交的位移)
 *
 * 默认的位移提交方式是自动提交, 每5秒提交一次, 提交的位移为poll()方法拉取的最大位移 + 1.
 *
 * 默认的位移提交方式提供at least once的消息下发含义, 但是如果消费者消费完后来不及提交就宕机了,
 * 或者2次提交位移之间发生了再均衡, 会导致消息重复消费, 因为消费者恢复后从committedOffset开始消费.
 *
 * 如果消息不能在poll()方法指定的时间间隔内完成逻辑处理, 会导致committedOffset大于lastConsumedOffset, 从而导致消息遗失.
 *
 * 手动提交提交的位移为下一条待消费消息的位移.
 *
 * kafka的位移为什么保存在kafka集群中而不是消费者自己保存?
 */
public class OffsetTest {
    public static void main(String[] args) {
        Properties props = Configurations.consumer();
        TopicPartition tp = new TopicPartition("test", 0);
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.assign(Collections.singletonList(tp));
        List<ConsumerRecord<String, String>> records = consumer.poll(Duration.ofMillis(1000L)).records(tp);
        System.out.println("records count: " + records.size());
        if (records.size() == 0) return;
        consumer.commitSync();
        System.out.println("LastConsumedOffset: " + records.get(records.size() - 1).offset());
        System.out.println("Next record offset: " + consumer.position(tp));
        System.out.println("Committed offset: " + consumer.committed(Collections.singleton(tp)).get(tp).offset());
    }
}
