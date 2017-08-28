package dtprogrammer.github.io.p62;

import java.util.Arrays;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * Time complexity: O(m * n)
 * Space complexity: O (m * n)
 */
public class Solution {
    public int uniquePaths(int m, int n) {

        int[][] memo = new int[m][n];

        Arrays.fill(memo[m - 1], 1);
        for (int i = 0; i < m; i++) {
            memo[i][n - 1] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                memo[i][j] = memo[i][j + 1] + memo[i + 1][j];
            }
        }
        return memo[0][0];
    }
}
