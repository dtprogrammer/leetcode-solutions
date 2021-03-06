package dtprogrammer.github.io.p98;

import dtprogrammer.github.io.common.TreeNode;

/**
 * 98. Validate Binary Search Tree
 * <p>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1
 *  2
 * / \
 * 1   3
 * Binary tree [2,1,3], return true.
 * Example 2:
 *  1
 * / \
 * 2   3
 * Binary tree [1,2,3], return false.
 * <p>
 * Time complexity: O(n)
 */
public class Solution {

    public boolean isValidBST(TreeNode root) {
        TreeNodeWrapper prev = new TreeNodeWrapper(null);
        return isValidBST(root, prev);
    }

    private boolean isValidBST(TreeNode root, TreeNodeWrapper prev) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left, prev)) {
            return false;
        }

        if (prev.node != null && root.val <= prev.node.val) {
            return false;
        }
        prev.node = root;
        return isValidBST(root.right, prev);
    }

    /**
     * A wrapper class around TreeNode to retain the value across recursive call
     */
    private class TreeNodeWrapper {
        TreeNode node;

        TreeNodeWrapper(TreeNode node) {
            this.node = node;
        }
    }
}
