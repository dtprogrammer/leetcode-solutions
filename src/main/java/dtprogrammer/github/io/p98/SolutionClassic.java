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
 * 2
 * / \
 * 1   3
 * Binary tree [2,1,3], return true.
 * Example 2:
 * 1
 * / \
 * 2   3
 * Binary tree [1,2,3], return false.
 * This approach is the classic approach to solve this problem although it depends on Integer.MIN_VALUE and Integer
 * .MAX_VALUE which is not very nice. See other solutions.
 * Time complexity: O(n)
 */
public class SolutionClassic {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }

        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }

        return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
    }
}
