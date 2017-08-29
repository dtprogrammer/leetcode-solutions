package dtprogrammer.github.io.p64;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        int[][] array = {{2, 4, 6}, {7, 1, 3}, {8, 2, 1}};
        Assert.assertEquals(10, solution.minPathSum(array));
        array = new int[0][0];
        Assert.assertEquals(Integer.MIN_VALUE, solution.minPathSum(array));
    }
}
