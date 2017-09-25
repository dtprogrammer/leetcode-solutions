package dtprogrammer.github.io.p237;

import dtprogrammer.github.io.common.ListNode;

/**
 * 237. Delete Node in a Linked List
 * http://dtprogrammer.github.io/237-delete-node-in-a-linked-list/
 */
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
