package dtprogrammer.github.io.p28;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();

        Assert.assertEquals(3, solution.strStr("mango apple", "g"));
        Assert.assertEquals(-1, solution.strStr("mango apple", "x"));
        Assert.assertEquals(0, solution.strStr("mango apple", ""));
        Assert.assertEquals(0, solution.strStr("", ""));
        Assert.assertEquals(-1, solution.strStr("", "a"));
        Assert.assertEquals(-1, solution.strStr("    ", "a"));
    }
}
