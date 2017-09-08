package dtprogrammer.github.io.p26;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {

        Solution solution = new Solution();
        int[] array = {1, 1, 2};
        Assert.assertEquals(2, solution.removeDuplicates(array));

        int[] array2 = {1, 1, 2, 3, 4, 4, 4, 5, 5, 6};
        Assert.assertEquals(6, solution.removeDuplicates(array2));

    }
}
