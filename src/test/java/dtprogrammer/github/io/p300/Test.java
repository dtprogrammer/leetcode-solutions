package dtprogrammer.github.io.p300;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        int[] array = {10, 9, 2, 5, 3, 7, 101, 18};
        Assert.assertEquals(4, solution.lengthOfLIS(array));
    }
}
