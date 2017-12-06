package dtprogrammer.github.io.p315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Integer[] result = new Integer[nums.length];
        Node node = null;
        // visit the array from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            node = addToTree(result, node, i, nums[i], 0);
        }
        return Arrays.asList(result);
    }

    private Node addToTree(Integer[] result, Node node, int i, int val, int preSum) {
        if (node == null) {
            result[i] = preSum;
            return new Node(val, 0);
        }
        if (node.val == val) {
            node.dupCount += 1;
            result[i] = preSum + node.sum;
        } else if (node.val < val) {
            node.right = addToTree(result, node.right, i, val, preSum + node.sum + node.dupCount);
        } else {
            node.sum += 1;
            node.left = addToTree(result, node.left, i, val, preSum);
        }
        return node;
    }


    private class Node {
        Node left, right;
        int val, sum, dupCount;

        Node(int val, int sum) {
            this.val = val;
            this.sum = sum;
            this.dupCount = 1;
        }
    }
}
