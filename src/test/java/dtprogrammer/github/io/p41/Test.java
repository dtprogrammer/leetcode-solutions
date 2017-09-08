package dtprogrammer.github.io.p41;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Solution soluton = new Solution();

        int[] array = {1, 2, 0};
        Assert.assertEquals(3, soluton.firstMissingPositive(array));

        int[] array2 = {3, 4, -1, 1};
        Assert.assertEquals(2, soluton.firstMissingPositive(array2));
    }
}
