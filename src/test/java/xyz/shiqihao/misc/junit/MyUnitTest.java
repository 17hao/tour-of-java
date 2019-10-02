package xyz.shiqihao.misc.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyUnitTest {
    private MyUnit myUnit = new MyUnit();

    @Test
    void testConcatenate() {
        String result = myUnit.concatenate("o", "ne");
        assertEquals("one", result);
    }
}
