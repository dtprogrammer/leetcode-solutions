package dtprogrammer.github.io.p347;

import org.junit.Assert;

import java.util.Arrays;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        int[] array = {1, 1, 1, 2, 2, 3};
        Assert.assertEquals(Arrays.asList(1, 2), solution.topKFrequent(array, 2));
//        Assert.assertTrue(Arrays.equals(expected, solution.));
    }
}
