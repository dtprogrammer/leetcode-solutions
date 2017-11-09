package dtprogrammer.github.io.p329;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.longestIncreasingPath(null));
        Assert.assertEquals(0, solution.longestIncreasingPath(new int[][]{null}));
        Assert.assertEquals(0, solution.longestIncreasingPath(new int[][]{{}}));
        Assert.assertEquals(4, solution.longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
    }
}
