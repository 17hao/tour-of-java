package xyz.shiqihao.advanced.concurrency.pattern.future;

public class Host {
    public Data request(int count, char c) {
        System.out.println("  request(" + count + ", " + c + ") BEGIN!");
        final FutureData futureData = new FutureData();
        new Thread(() -> futureData.setRealData(new RealData(count, c))).start();
        System.out.println("  request(" + count + ", " + c + ") END!");
        return futureData;
    }
}
