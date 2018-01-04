package dtprogrammer.github.io.p76;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"));
    }
}
