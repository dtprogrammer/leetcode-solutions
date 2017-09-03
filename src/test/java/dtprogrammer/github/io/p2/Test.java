package dtprogrammer.github.io.p2;

import dtprogrammer.github.io.common.ListNode;
import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        ListNode l1 = ListNode.createList(2, 4, 3);
        ListNode l2 = ListNode.createList(5, 6, 4);

        Solution solution = new Solution();

        Assert.assertTrue(ListNode.isEqual(ListNode.createList(7, 0, 8), solution.addTwoNumbers(l1, l2)));

        l1 = ListNode.createList(1);
        l2 = ListNode.createList(9, 9);

        Assert.assertTrue(ListNode.isEqual(ListNode.createList(0, 0, 1), solution.addTwoNumbers(l1, l2)));
    }

}
