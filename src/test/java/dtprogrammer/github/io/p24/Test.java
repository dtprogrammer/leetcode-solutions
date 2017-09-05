package dtprogrammer.github.io.p24;

import dtprogrammer.github.io.common.ListNode;
import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(ListNode.isEqual(ListNode.createList(2, 1, 4, 3),
                solution.swapPairs(ListNode.createList(1, 2, 3, 4))));
        Assert.assertTrue(ListNode.isEqual(ListNode.createList(2, 1, 3),
                solution.swapPairs(ListNode.createList(1, 2, 3))));
        Assert.assertTrue(ListNode.isEqual(ListNode.createList(2, 1), solution.swapPairs(ListNode.createList(1, 2))));
        Assert.assertTrue(ListNode.isEqual(ListNode.createList(1), solution.swapPairs(ListNode.createList(1))));
        Assert.assertTrue(ListNode.isEqual(ListNode.createList(), solution.swapPairs(ListNode.createList())));
    }
}
