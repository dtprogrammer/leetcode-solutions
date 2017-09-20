package dtprogrammer.github.io.p52;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.totalNQueens(4));
        Assert.assertEquals(92, solution.totalNQueens(8));
    }
}
