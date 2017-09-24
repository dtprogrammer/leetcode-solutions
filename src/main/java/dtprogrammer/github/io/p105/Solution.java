package dtprogrammer.github.io.p105;

import dtprogrammer.github.io.common.TreeNode;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * http://dtprogrammer.github.io/105-construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] preorderIndex = {0};
        return buildTree(preorder, inorder, preorderIndex, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int[] preorderIndex, int inorderStart, int inorderEnd) {

        if (preorderIndex[0] >= preorder.length) {
            return null;
        }
        int inorderIndex = findIndex(inorder, inorderStart, inorderEnd, preorder[preorderIndex[0]]);
        preorderIndex[0] = preorderIndex[0] + 1;
        TreeNode root = new TreeNode(inorder[inorderIndex]);
        root.left = inorderIndex > inorderStart ? buildTree(preorder, inorder, preorderIndex, inorderStart,
                inorderIndex - 1) : null;
        root.right = inorderIndex < inorderEnd ? buildTree(preorder, inorder, preorderIndex, inorderIndex + 1,
                inorderEnd) : null;
        return root;
    }

    private int findIndex(int[] inorder, int start, int end, int element) {
        int i = start;
        for (; i <= end; i++) {
            if (inorder[i] == element) {
                break;
            }
        }
        return i;
    }
}
