package dtprogrammer.github.io.p543;

import dtprogrammer.github.io.common.TreeNode;

/**
 * 543. Diameter of Binary Tree
 */
public class Solution {
    int maxDepth = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return maxDepth;
    }

    private int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = diameter(root.left);
        int right = diameter(root.right);

        maxDepth = Math.max(maxDepth, left + right);

        return Math.max(left, right) + 1;
    }
}
