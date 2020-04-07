package xyz.shiqihao.advanced.jvm;

import java.nio.ByteBuffer;

/**
 * Direct memory read/write efficiency is higher than heap;
 */
public class AccessDirectMem {
    void directAccess() {
        long startTime = System.currentTimeMillis();
        ByteBuffer buffer = ByteBuffer.allocateDirect(500);
        for (int i = 0_0; i < 1000000; i++) {
            for (int j = 0; j < 99; j++) {
                buffer.putInt(j);
            }
            buffer.flip();
            for (int j = 0; j < 99; j++) {
                buffer.get();
            }
            buffer.clear();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("direct access time: " + (endTime - startTime));
    }

    void bufferAccess() {
        long startTime = System.currentTimeMillis();
        ByteBuffer buffer = ByteBuffer.allocate(500);
        for (int i = 0_0; i < 1000000; i++) {
            for (int j = 0; j < 99; j++) {
                buffer.putInt(j);
            }
            buffer.flip();
            for (int j = 0; j < 99; j++) {
                buffer.get();
            }
            buffer.clear();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("buffer access time: " + (endTime - startTime));
    }

    public static void main(String[] args) {
        AccessDirectMem ins = new AccessDirectMem();
        ins.bufferAccess();
        ins.directAccess();
        System.out.println("=========");
        ins.bufferAccess();
        ins.directAccess();
    }
}
