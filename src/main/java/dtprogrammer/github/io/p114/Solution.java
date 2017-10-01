package dtprogrammer.github.io.p114;

import dtprogrammer.github.io.common.TreeNode;

/**
 * 114. Flatten Binary Tree to Linked List
 * http://dtprogrammer.github.io/114-flatten-binary-tree-to-linked-list/
 */
public class Solution {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
