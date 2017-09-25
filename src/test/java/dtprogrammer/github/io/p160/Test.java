package dtprogrammer.github.io.p160;

import dtprogrammer.github.io.common.ListNode;
import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();

        Assert.assertEquals(null, solution.getIntersectionNode(ListNode.createList(1, 3), null));
    }
}
