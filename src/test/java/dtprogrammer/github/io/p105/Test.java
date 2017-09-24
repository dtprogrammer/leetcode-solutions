package dtprogrammer.github.io.p105;

import dtprogrammer.github.io.common.TreeNode;
import org.junit.Assert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        int[] preorder = {1, 2};
        int[] inorder = {2, 1};
        List<Integer> actual = new LinkedList<>();
        TreeNode.printInOrder(solution.buildTree(preorder, inorder), actual);
        Assert.assertTrue(Arrays.equals(inorder, actual.stream().mapToInt(i -> i).toArray()));

        int[] preorder2 = {1, 2};
        int[] inorder2 = {1, 2};
        actual = new LinkedList<>();
        TreeNode.printInOrder(solution.buildTree(preorder2, inorder2), actual);
        Assert.assertTrue(Arrays.equals(inorder2, actual.stream().mapToInt(i -> i).toArray()));
    }
}
