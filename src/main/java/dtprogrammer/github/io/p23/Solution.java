package dtprogrammer.github.io.p23;

import dtprogrammer.github.io.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * Time complexity: If there are k lists and in total lists contains n elements each the complexity will
 * be O n(log k). The complexity of insertion in the priority queue is log k and we do this for n elements.
 * Space complexity: The space complexity is the space taken by the priority queue which is O(k)
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummyHead;

        while (!queue.isEmpty()) {
            ListNode curTarget = queue.poll();
            cur.next = curTarget;
            cur = cur.next;

            // add the next elements from the list
            if (curTarget.next != null) {
                queue.offer(curTarget.next);
            }
        }

        return dummyHead.next;
    }
}
