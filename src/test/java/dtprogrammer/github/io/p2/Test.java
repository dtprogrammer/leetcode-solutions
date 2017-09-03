package dtprogrammer.github.io.p2;

import dtprogrammer.github.io.common.ListNode;
import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        ListNode l1 = createList(2, 4, 3);
        ListNode l2 = createList(5, 6, 4);

        Solution solution = new Solution();

        assertEquals(createList(7, 0, 8), solution.addTwoNumbers(l1, l2));

        l1 = createList(1);
        l2 = createList(9, 9);

        assertEquals(createList(0, 0, 1), solution.addTwoNumbers(l1, l2));
    }

    private ListNode createList(int... values) {
        ListNode dummyHead = new ListNode(0);
        ListNode curNode = dummyHead;
        for (int value : values) {
            curNode.next = new ListNode(value);
            curNode = curNode.next;
        }
        return dummyHead.next;
    }

    private void assertEquals(ListNode expected, ListNode actual) {
        while (expected != null && actual != null) {
            if (expected.val != actual.val) {
                Assert.fail();
            }
            expected = expected.next;
            actual = actual.next;
        }
        if (expected != null || actual != null) {
            Assert.fail();
        }
    }
}
