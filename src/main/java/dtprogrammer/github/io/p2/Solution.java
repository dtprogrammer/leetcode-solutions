package dtprogrammer.github.io.p2;

import dtprogrammer.github.io.common.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * <p>
 * Time Complexity: O max (m, n) and same is the space complexity
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummyHead = new ListNode(Integer.MAX_VALUE);
        ListNode curNode = dummyHead;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            sum += l1 != null ? l1.val : 0;
            sum += l2 != null ? l2.val : 0;
            sum += carry;
            carry = sum / 10;
            curNode.next = new ListNode(sum % 10);
            curNode = curNode.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            curNode.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
