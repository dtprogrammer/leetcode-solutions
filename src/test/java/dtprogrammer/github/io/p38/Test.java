package dtprogrammer.github.io.p38;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();

        Assert.assertEquals("1", solution.countAndSay(1));
        Assert.assertEquals("11", solution.countAndSay(2));
        Assert.assertEquals("21", solution.countAndSay(3));
        Assert.assertEquals("1211", solution.countAndSay(4));
        Assert.assertEquals("111221", solution.countAndSay(5));
        Assert.assertEquals("312211", solution.countAndSay(6));
    }
}
