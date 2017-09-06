package dtprogrammer.github.io.p98;

import dtprogrammer.github.io.common.TreeNode;

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
