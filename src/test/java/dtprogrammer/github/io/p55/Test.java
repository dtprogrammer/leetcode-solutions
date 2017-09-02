package dtprogrammer.github.io.p55;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();

        int[] array = null;
        Assert.assertTrue(solution.canJump(array));

        array = new int[0];
        Assert.assertTrue(solution.canJump(array));

        int[] valid = {2, 3, 1, 1, 4};
        Assert.assertTrue(solution.canJump(valid));

        int[] invalid = {3, 2, 1, 0, 4};
        Assert.assertFalse(solution.canJump(invalid));
    }
}
