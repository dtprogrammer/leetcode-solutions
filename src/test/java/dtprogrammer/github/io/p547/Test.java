package dtprogrammer.github.io.p547;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));

    }
}
