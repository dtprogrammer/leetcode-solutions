package dtprogrammer.github.io.p220;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.containsNearbyAlmostDuplicate(new int[]{-3, 3}, 2, 4));

        Assert.assertFalse(solution.containsNearbyAlmostDuplicate(new int[]{1, 3, 1}, 1, 1));
    }
}
