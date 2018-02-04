package dtprogrammer.github.io.p298;

import dtprogrammer.github.io.common.TreeNode;

/**
 * 298. Binary Tree Longest Consecutive Sequence
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * <p>
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 * <p>
 * For example,
 * <p>
 * 1
 * \
 * 3
 * /     \
 * 2      4
 * \
 * 5
 * <p>
 * Longest consecutive sequence path is 3-4-5, so return 3.
 * <p>
 * 2
 * \
 * 3
 * /
 * 2
 * /
 * 1
 * <p>
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 * <p>
 * Time Complexity: O(n) for the traversal
 * Space Complexity: O(n) for the stack space
 */
public class Solution {
    public int longestConsecutive(TreeNode root) {
        return longestConsecutive(root, null, 0);
    }

    private int longestConsecutive(TreeNode root, TreeNode parent, int length) {
        if (root == null) {
            return length;
        }
        length = parent != null && root.val == parent.val + 1 ? length + 1 : 1;

        return Math.max(length, Math.max(longestConsecutive(root.left, root, length),
                longestConsecutive(root.right, root, length)));
    }
}
