package dtprogrammer.github.io.common;

import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode TreeNode class for testing and dedbugging
 */
public class TreeNode {
    public final int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public static void printInOrder(TreeNode root) {
        List<Integer> traversal = new LinkedList<>();
        printInOrder(root, traversal);
        System.out.println(traversal);
    }

    public static void printInOrder(TreeNode root, List<Integer> traversal) {
        if (root == null) {
            return;
        }
        printInOrder(root.left, traversal);
        traversal.add(root.val);
        printInOrder(root.right, traversal);
    }
}
