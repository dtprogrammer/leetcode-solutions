package dtprogrammer.github.io.p48;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution soluton = new Solution();

        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expectedArray = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        soluton.rotate(array);
        Assert.assertArrayEquals(expectedArray, array);
    }
}
