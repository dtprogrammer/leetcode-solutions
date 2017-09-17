package dtprogrammer.github.io.p103;

import dtprogrammer.github.io.common.TreeNode;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);

        System.out.println(solution.zigzagLevelOrder(root));
    }
}
