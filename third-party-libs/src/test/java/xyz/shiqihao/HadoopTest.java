package xyz.shiqihao;

import org.junit.Test;
import xyz.shiqihao.hadoop.ch06.Test1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HadoopTest {
    @Test
    public void testHadoopConf() {
        Test1 t = new Test1();
        assertThat(t.getColor(), is("yellow"));
    }
}
