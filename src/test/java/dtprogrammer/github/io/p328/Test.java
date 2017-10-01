package dtprogrammer.github.io.p328;

import dtprogrammer.github.io.common.ListNode;
import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();

        Assert.assertTrue(ListNode.isEqual(null,
                solution.oddEvenList(null)));

        Assert.assertTrue(ListNode.isEqual(ListNode.createList(1),
                solution.oddEvenList(ListNode.createList(1))));

        Assert.assertTrue(ListNode.isEqual(ListNode.createList(1, 2),
                solution.oddEvenList(ListNode.createList(1, 2))));

        Assert.assertTrue(ListNode.isEqual(ListNode.createList(1, 3, 5, 2, 4),
                solution.oddEvenList(ListNode.createList(1, 2, 3, 4, 5))));

        Assert.assertTrue(ListNode.isEqual(ListNode.createList(1, 3, 5, 2, 4, 6),
                solution.oddEvenList(ListNode.createList(1, 2, 3, 4, 5, 6))));
    }
}
