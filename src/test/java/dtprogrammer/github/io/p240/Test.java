package dtprogrammer.github.io.p240;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() {
        Solution solution = new Solution();
        int[][] array = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        Assert.assertTrue(solution.searchMatrix(array, 5));
        Assert.assertFalse(solution.searchMatrix(array, 20));
    }
}
