package dtprogrammer.github.io.p84;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> indexes = new Stack<>();
        int maxArea = 0;

        for(int i = 0; i <= heights.length; i++) {
            int curHeight = i == heights.length ? 0 : heights[i];

            if (indexes.isEmpty() || curHeight >= heights[indexes.peek()]) {
                indexes.push(i);
            } else {
                int top = indexes.pop();
                maxArea = Math.max(maxArea, heights[top] * (indexes.isEmpty() ? i : i - 1 - indexes.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
