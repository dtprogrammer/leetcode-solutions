package dtprogrammer.github.io.p270;

import dtprogrammer.github.io.common.TreeNode;

/**
 * 270. Closest Binary Search Tree Value
 * <p>
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * <p>
 * Note:
 * <p>
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 * <p>
 * Time Complexity: O(n) for the traversal and then stack space
 */
public class Solution {
    public int closestValue(TreeNode root, double target) {
        TreeNode bound = root.val < target ? root.right : root.left;
        if (bound == null) {
            return root.val;
        }
        int otherBound = closestValue(bound, target);

        return Math.abs(root.val - target) < Math.abs(otherBound - target) ? root.val : otherBound;
    }
}
