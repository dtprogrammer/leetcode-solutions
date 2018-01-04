package dtprogrammer.github.io.p84;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(10, solution.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
