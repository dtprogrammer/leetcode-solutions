package dtprogrammer.github.io.p206;

import dtprogrammer.github.io.common.ListNode;
import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        ListNode head = ListNode.createList(1, 2, 3);
        Solution solution = new Solution();
        Assert.assertTrue(ListNode.isEqual(ListNode.createList(3, 2, 1), solution.reverseList(head)));
    }
}
