package dtprogrammer.github.io.algo.dp;

import org.junit.Assert;

import java.util.Arrays;

public class TextJustificationTest {

    @org.junit.Test
    public void test() throws Exception {
        TextJustification solution = new TextJustification();
        Assert.assertEquals(Arrays.asList("tushar", "roy likes", "to code"),
                solution.fullJustify(new String[]{"tushar", "roy", "likes", "to", "code"}, 10));
    }
}
