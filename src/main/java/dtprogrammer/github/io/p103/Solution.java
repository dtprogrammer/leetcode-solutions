package dtprogrammer.github.io.p103;

import dtprogrammer.github.io.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * http://dtprogrammer.github.io/103-binary-tree-zigzag-level-order-traversal/
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = queue.size();
        boolean rToL = false;
        while (!queue.isEmpty()) {
            LinkedList<Integer> curLevel = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (rToL) {
                    curLevel.addFirst(node.val);
                } else {
                    curLevel.addLast(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(curLevel);
            levelSize = queue.size();
            rToL = !rToL;
        }
        return result;
    }
}
