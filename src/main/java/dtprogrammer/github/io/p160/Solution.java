package dtprogrammer.github.io.p160;

import dtprogrammer.github.io.common.ListNode;

/**
 * 160. Intersection of Two Linked Lists
 * http://dtprogrammer.github.io/160-intersection-of-two-linked-lists/
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA, nodeB = headB;

        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }

        return nodeA;
    }
}
