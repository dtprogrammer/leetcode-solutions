package dtprogrammer.github.io.p236;

import dtprogrammer.github.io.common.TreeNode;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * http://dtprogrammer.github.io/236-lowest-common-ancestor-of-a-binary-tree/
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        return left == null ? right : right == null ? left : root;
    }
}
