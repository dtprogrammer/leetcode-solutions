package dtprogrammer.github.io.p11;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        Solution solution = new Solution();

        Assert.assertEquals(49, solution.maxArea(array));
    }
}
