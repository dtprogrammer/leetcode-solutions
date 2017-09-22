package dtprogrammer.github.io.p66;

import org.junit.Assert;

import java.util.Arrays;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        int[] number = {2, 3, 4};
        int[] expected = {2, 3, 5};
        Assert.assertTrue(Arrays.equals(expected, solution.plusOne(number)));

        int[] number2 = {9, 9, 9};
        int[] expected2 = {1, 0, 0, 0};
        Assert.assertTrue(Arrays.equals(expected2, solution.plusOne(number2)));

        int[] number3 = {5, 6, 9};
        int[] expected3 = {5, 7, 0};
        Assert.assertTrue(Arrays.equals(expected3, solution.plusOne(number3)));
    }
}
