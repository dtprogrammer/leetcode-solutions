package dtprogrammer.github.io.p238;

import org.junit.Assert;

import java.util.Arrays;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        int[] array = {1, 2, 3, 4};
        int[] expected = {24, 12, 8, 6};
        Assert.assertTrue(Arrays.equals(expected, solution.productExceptSelf(array)));
    }
}
