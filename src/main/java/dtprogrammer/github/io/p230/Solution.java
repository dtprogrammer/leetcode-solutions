package dtprogrammer.github.io.p230;

import dtprogrammer.github.io.common.TreeNode;

public class Solution {

    int counter = 0;
    int result = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        kthSmallestHelper(root, k);
        return result;
    }

    private void kthSmallestHelper(TreeNode root, int k) {
        if (root == null)
            return;
        kthSmallestHelper(root.left, k);
        counter++;
        if (k == counter) {
            result = root.val;
            return;
        }
        kthSmallestHelper(root.right, k);
    }
}
