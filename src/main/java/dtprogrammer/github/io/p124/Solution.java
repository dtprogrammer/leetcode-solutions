package dtprogrammer.github.io.p124;

import dtprogrammer.github.io.common.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 */
public class Solution {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return maxSum;
    }

    private int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, maxPathSumHelper(root.left));
        int right = Math.max(0, maxPathSumHelper(root.right));
        maxSum = Math.max(maxSum, root.val + left + right);
        return Math.max(left, right) + root.val;
    }
}
