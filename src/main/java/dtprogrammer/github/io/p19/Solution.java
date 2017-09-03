package dtprogrammer.github.io.p19;

import dtprogrammer.github.io.common.ListNode;

/**
 * 19. Remove Nth Node From End of List
 * <p>
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * For example,
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * <p>
 * Time complexity: O(n)
 * Space complexity: O (1)
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // make the two pointer at n - 1 diff since we want to be one node behind the node to be deleted

        ListNode ahead = dummyHead, behind = dummyHead;
        while (n > 0) {
            ahead = ahead.next;
            n--;
        }

        /// until ahead reaches the last node
        while (ahead.next != null) {
            ahead = ahead.next;
            behind = behind.next;
        }

        // now behind points to the node just before the node to deleted
        behind.next = behind.next.next;

        return dummyHead.next;
    }
}
