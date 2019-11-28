package xyz.shiqihao.misc.disruptor.quickstart;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.nio.ByteBuffer;

public class LongEventMain {
    public static void main(String[] args) throws Exception {
        final int bufferSize = 1024;

        Disruptor<LongEvent> disruptor = new Disruptor<>(LongEvent::new, bufferSize, DaemonThreadFactory.INSTANCE);

        disruptor.handleEventsWith((event, sequence, endOfBatch) -> System.out.println(event));

        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long i = 0; i < 5; i++) {
            bb.putLong(0, i);
            ringBuffer.publishEvent((event, sequence, byteBuffer) ->
                    event.setValue(byteBuffer.get(0)), bb);
            Thread.sleep(1000);
        }
    }
}
