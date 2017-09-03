package dtprogrammer.github.io.p19;

import dtprogrammer.github.io.common.ListNode;
import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();

        Assert.assertTrue(ListNode.isEqual(ListNode.createList(1, 2, 3, 5),
                solution.removeNthFromEnd(ListNode.createList(1, 2, 3, 4, 5), 2)));

        Assert.assertTrue(ListNode.isEqual(ListNode.createList(1).next,
                solution.removeNthFromEnd(ListNode.createList(1), 1)));
    }
}
