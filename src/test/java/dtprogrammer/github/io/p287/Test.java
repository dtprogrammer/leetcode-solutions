package dtprogrammer.github.io.p287;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.findDuplicate(new int[]{1, 2, 9, 4, 2, 6, 5, 8, 3, 7}));
    }
}
