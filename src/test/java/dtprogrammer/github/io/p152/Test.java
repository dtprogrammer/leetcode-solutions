package dtprogrammer.github.io.p152;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() {
        int[] array = {-2, 3, -4};
        Solution solution = new Solution();
        Assert.assertEquals(24, solution.maxProduct(array));
    }
}
