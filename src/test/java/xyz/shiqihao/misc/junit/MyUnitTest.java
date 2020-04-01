package xyz.shiqihao.misc.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyUnitTest {
    private MyUnit myUnit = new MyUnit();

    @Test
    public void testConcatenate() {
        String result = myUnit.concatenate("o", "ne");
        assertEquals("one", result);
    }
}
