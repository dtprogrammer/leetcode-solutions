package dtprogrammer.github.io.p568;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(12, solution.maxVacationDays(new int[][]{{0, 1, 1}, {1, 0, 1}, {1, 1, 0}},
                new int[][]{{1, 3, 1}, {6, 0, 3}, {3, 3, 3}}));
    }
}
