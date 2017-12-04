package dtprogrammer.github.io.p42;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        int totalTrapped = solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        Assert.assertEquals(6, totalTrapped);
    }
}
