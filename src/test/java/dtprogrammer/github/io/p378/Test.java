package dtprogrammer.github.io.p378;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        int[][] array = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        Assert.assertEquals(13, solution.kthSmallest(array, 8));

        int[][] array2 = {{1, 5}, {12, 13}};
        Assert.assertEquals(1, solution.kthSmallest(array2, 1));
        Assert.assertEquals(5, solution.kthSmallest(array2, 2));

        int[][] array3 = {{1}};
        Assert.assertEquals(1, solution.kthSmallest(array3, 1));
    }
}
