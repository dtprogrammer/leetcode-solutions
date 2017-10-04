package dtprogrammer.github.io.p206;

import dtprogrammer.github.io.common.ListNode;

/**
 * 206. Reverse Linked List
 * http://dtprogrammer.github.io/206-reverse-linked-list/
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;

        while (cur != null) {
            ListNode ahead = cur.next;
            cur.next = prev;
            prev = cur;
            cur = ahead;
        }
        return prev;
    }
}
