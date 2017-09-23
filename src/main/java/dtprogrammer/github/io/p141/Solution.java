package dtprogrammer.github.io.p141;

import dtprogrammer.github.io.common.ListNode;

/**
 * 141. Linked List Cycle
 * http://dtprogrammer.github.io/141-linked-list-cycle/
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = null, fast = head;
        while (fast != null && fast.next != null && slow != fast) {
            slow = slow == null ? fast : slow.next;
            fast = fast.next.next;
        }
        return (slow != null && fast != null) && slow == fast;
    }
}
