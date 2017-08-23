package dtprogrammer.github.io.p74;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() {
        Solution solution = new Solution();
        int[][] array = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};

        Assert.assertTrue(solution.searchMatrix(array, 3));

        int[][] single = {{1}};
        Assert.assertFalse(solution.searchMatrix(single, 2));
    }
}
