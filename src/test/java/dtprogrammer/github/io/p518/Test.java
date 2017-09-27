package dtprogrammer.github.io.p518;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        int[] coins = {1, 2, 5};

        Assert.assertEquals(4, solution.change(5, coins));
    }
}
