package dtprogrammer.github.io.p206;

import dtprogrammer.github.io.common.ListNode;

/**
 * 206. Reverse Linked List
 * http://dtprogrammer.github.io/206-reverse-linked-list/
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
