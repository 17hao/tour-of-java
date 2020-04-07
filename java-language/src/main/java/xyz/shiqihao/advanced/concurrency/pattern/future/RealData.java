package xyz.shiqihao.advanced.concurrency.pattern.future;

public class RealData implements Data {
    private String content;

    public RealData(int count, char c) {
        char[] buffer = new char[count];
        System.out.println("    making RealData(" + count + ", " + c + ") BEGIN!");
        for (int i = 0; i < count; i++) {
            buffer[i] = c;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("    making RealData(" + count + ", " + c + ") END!");
        content = new String(buffer);
    }

    @Override
    public String getContent() {
        return content;
    }
}
