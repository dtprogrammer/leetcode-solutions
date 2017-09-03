package dtprogrammer.github.io.p135;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();

        int[] array = null;
        Assert.assertEquals(0, solution.candy(array));

        array = new int[0];
        Assert.assertEquals(0, solution.candy(array));

        int[] anotherArray = {12, 4, 3, 11, 34, 34, 1, 67};

        Assert.assertEquals(16, solution.candy(anotherArray));
    }
}
