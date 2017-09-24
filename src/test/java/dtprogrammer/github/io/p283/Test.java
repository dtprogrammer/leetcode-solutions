package dtprogrammer.github.io.p283;

import org.junit.Assert;

import java.util.Arrays;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        int[] array = {0, 1, 0, 3, 12};
        int[] expected = {1, 3, 12, 0, 0};
        solution.moveZeroes(array);
        Assert.assertTrue(Arrays.equals(expected, array));

        int[] array2 = {1};
        int[] expected2 = {1};
        solution.moveZeroes(array2);
        Assert.assertTrue(Arrays.equals(expected2, array2));
    }
}
