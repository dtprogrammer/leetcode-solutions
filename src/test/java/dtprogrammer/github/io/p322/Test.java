package dtprogrammer.github.io.p322;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        int[] coins = {1, 2, 5};
        Assert.assertEquals(3, solution.coinChange(coins, 11));

        int[] coins2 = {2};
        Assert.assertEquals(-1, solution.coinChange(coins2, 3));

        int[] coins3 = {186, 419, 83, 408};
        Assert.assertEquals(20, solution.coinChange(coins3, 6249));
    }
}
