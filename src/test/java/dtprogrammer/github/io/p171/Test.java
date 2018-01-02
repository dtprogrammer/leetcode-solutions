package dtprogrammer.github.io.p171;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.titleToNumber(""));
        Assert.assertEquals(1, solution.titleToNumber("A"));
        Assert.assertEquals(53, solution.titleToNumber("BA"));
    }
}
