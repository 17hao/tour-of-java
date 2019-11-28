package xyz.shiqihao.misc.disruptor.quickstart;

public class LongEvent {
    private long value;

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "event's value is: " + value;
    }
}
