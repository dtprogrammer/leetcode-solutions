package dtprogrammer.github.io.p34;


import org.junit.Assert;

import java.util.Arrays;

public class Test {
    @org.junit.Test
    public void test() throws Exception {

        Solution soluton = new Solution();
        int[] array = {5, 7, 7, 8, 8, 10};
        int[] expected = {3, 4};

        Assert.assertTrue(Arrays.equals(expected, soluton.searchRange(array, 8)));

    }
}
