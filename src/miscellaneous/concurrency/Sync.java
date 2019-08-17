package miscellaneous.concurrency;

public class Sync {
    public static void main(String[] args) {
        SubSync subSync = new SubSync();
        Thread t1 = new Thread(subSync::writer);
        Thread t2 = new Thread(subSync::reader);
        t1.start();
        t2.start();
    }
}

class SubSync {
    private int i = 0;
    void reader() {
        System.out.println("read i is: " + i);
    }

    synchronized void writer() {
        int count = 0;
        while (count < 100000) {
            count++;
            i++;
        }
        System.out.println("write i is: " + i);
    }
}
