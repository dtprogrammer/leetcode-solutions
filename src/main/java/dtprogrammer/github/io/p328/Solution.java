package dtprogrammer.github.io.p328;

import dtprogrammer.github.io.common.ListNode;

/**
 * 328. Odd Even Linked List
 * http://localhost:2368/328-odd-even-linked-list/
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
