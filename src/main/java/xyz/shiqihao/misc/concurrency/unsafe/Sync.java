package xyz.shiqihao.misc.concurrency.unsafe;

public class Sync {
    public static void main(String[] args) {
        final AuxSync auxSync = new AuxSync();
        Thread t1 = new Thread(auxSync::writer);
        Thread t2 = new Thread(auxSync::reader);
        t1.start();
        t2.start();

        final AuxSync2 auxSync2 = new AuxSync2();
        Thread t3 = new Thread(auxSync2::writer);
        Thread t4 = new Thread(AuxSync2::reader);
        t3.start();
        t4.start();
    }
}

class AuxSync {
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

class AuxSync2 {
    private static int i = 0;
    synchronized static void reader() {
        System.out.println("aux2 read i is: " + i);
    }

    synchronized void writer() {
        int count = 0;
        while (count < 10000) {
            count++;
            i++;
        }
        System.out.println("aux2 write i is: " + i);
    }
}

class AuxSync3 {
    private int i = 0;

    void add() {
        synchronized (new Object()) {
            int count = 0;
            while (count < 100000) {
                count++;
                i++;
            }
        }
    }

    int value() {
        synchronized (new Object()) {
            return i;
        }
    }
}