package dtprogrammer.github.io.p24;

import dtprogrammer.github.io.common.ListNode;

/**
 * 24. Swap Nodes in Pairs
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p>
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself
 * can be changed.
 * <p>
 * Time complexity: O(n)
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        head = dummyHead;
        ListNode middle, right;

        while (head.next != null && head.next.next != null) {
            middle = head.next;
            right = head.next.next;

            head.next = right;
            middle.next = right.next;
            right.next = middle;

            head = head.next.next;
        }
        return dummyHead.next;
    }
}
