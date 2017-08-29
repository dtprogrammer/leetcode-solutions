package dtprogrammer.github.io.p64;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes
 * the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Time complexity: O (m * n) to compute the path matrix
 * Space complexity: O (n)
 */
public class Solution {
    int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return Integer.MIN_VALUE;
        }
        int cols = grid[0].length;

        int[] memo = new int[cols];

        // init first row col
        memo[0] = grid[0][0];
        for (int i = 1; i < cols; i++) {
            memo[i] = memo[i - 1] + grid[0][i];
        }

        fillCells(grid, memo);
        return memo[cols - 1];
    }

    private void fillCells(int[][] grid, int[] memo) {
        for (int i = 1; i < grid.length; i++) {
            memo[0] = memo[0] + grid[i][0];
            for (int j = 1; j < grid[0].length; j++) {
                memo[j] = grid[i][j] + Math.min(memo[j], memo[j - 1]);
            }
        }
    }
}
