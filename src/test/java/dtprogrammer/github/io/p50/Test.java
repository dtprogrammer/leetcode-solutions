package dtprogrammer.github.io.p50;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();

        Assert.assertEquals(4, solution.myPow(2, 2), 0);
        Assert.assertEquals(1, solution.myPow(2, 0), 0);
        Assert.assertEquals(0.25, solution.myPow(2, -2), 0);
        Assert.assertEquals(0, solution.myPow(0, -2147483648), 0);
        Assert.assertEquals(1, solution.myPow(1, -2147483648), 0);
    }
}
