package dtprogrammer.github.io.p325;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(4, solution.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3));
    }
}
