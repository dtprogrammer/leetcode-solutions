package dtprogrammer.github.io.p35;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.searchInsert(new int[]{1,3,5,6}, 5));
        Assert.assertEquals(1, solution.searchInsert(new int[]{1,3,5,6}, 2));
        Assert.assertEquals(4, solution.searchInsert(new int[]{1,3,5,6}, 7));
        Assert.assertEquals(0, solution.searchInsert(new int[]{1,3,5,6}, 0));
    }
}
