package dtprogrammer.github.io.p210;

import org.junit.Assert;

import java.util.Arrays;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();

        Assert.assertTrue(Arrays.equals(new int[]{0, 1}, solution.findOrder(2, new int[][]{{1, 0}})));
        int[] sequence = solution.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        Assert.assertTrue(Arrays.equals(new int[]{0, 1, 2, 3}, sequence) ||
                Arrays.equals(new int[]{0, 2, 1, 3}, sequence));
    }
}
