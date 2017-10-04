package dtprogrammer.github.io.p116;

import dtprogrammer.github.io.common.TreeLinkNode;

/**
 * 116. Populating Next Right Pointers in Each Node
 * http://dtprogrammer.github.io/116-populating-next-right-pointers-in-each-node/
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode prev = root, cur;
        while (prev.left != null) {
            cur = prev;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            prev = prev.left;
        }
    }
}
