package dtprogrammer.github.io.p461;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.hammingDistance(2, 6));
        Assert.assertEquals(2, solution.hammingDistance(1, 4));
    }
}
