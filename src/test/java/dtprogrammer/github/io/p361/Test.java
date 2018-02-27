package dtprogrammer.github.io.p361;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.maxKilledEnemies(new char[][]{{'0', 'E', '0', '0'},
                {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}}));
    }
}
