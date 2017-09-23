package dtprogrammer.github.io.p654;

import dtprogrammer.github.io.common.TreeNode;

/**
 * 654. Maximum Binary Tree
 * http://dtprogrammer.github.io/654-maximum-binary-tree/
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        int maxIndex = findMax(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = maxIndex > start ? constructMaximumBinaryTree(nums, start, maxIndex - 1) : null;
        root.right = maxIndex < end ? constructMaximumBinaryTree(nums, maxIndex + 1, end) : null;
        return root;
    }

    private int findMax(int[] nums, int start, int end) {
        int max = start;
        for (int i = start + 1; i <= end; i++) {
            max = nums[max] < nums[i] ? i : max;
        }
        return max;
    }
}
