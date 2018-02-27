package dtprogrammer.github.io.p361;

/**
 * 361. Bomb Enemy
 */
public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int[][] memo = new int[rowSize][colSize];
        int count = 0;
        // left to right
        for (int i = 0; i < rowSize; i++) {
            count = 0;
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] == '0') {
                    memo[i][j] += count; // if empty position then store the number of enemies seen
                } else if (grid[i][j] == 'E') {
                    count++; // if enemy then increment the count denoting that we have seen one
                } else {
                    // in case of 'W' reset the count since the bomb will not be able to kill
                    count = 0;
                }
            }
        }

        // right to left
        for (int i = 0; i < rowSize; i++) {
            count = 0;
            for (int j = colSize - 1; j >= 0; j--) {
                if (grid[i][j] == '0') {
                    memo[i][j] += count; // if empty position then store the number of enemies seen
                } else if (grid[i][j] == 'E') {
                    count++; // if enemy then increment the count denoting that we have seen one
                } else {
                    // in case of 'W' reset the count since the bomb will not be able to kill
                    count = 0;
                }
            }
        }

        // top to bottom
        for (int j = 0; j < colSize; j++) {
            count = 0;
            for (int i = 0; i < rowSize; i++) {
                if (grid[i][j] == '0') {
                    memo[i][j] += count; // if empty position then store the number of enemies seen
                } else if (grid[i][j] == 'E') {
                    count++; // if enemy then increment the count denoting that we have seen one
                } else {
                    // in case of 'W' reset the count since the bomb will not be able to kill
                    count = 0;
                }
            }
        }

        // bottom to top
        int max = 0;
        for (int j = 0; j < colSize; j++) {
            count = 0;
            for (int i = rowSize - 1; i >= 0; i--) {
                if (grid[i][j] == '0') {
                    memo[i][j] += count; // if empty position then store the number of enemies seen
                    max = Math.max(memo[i][j], max);
                } else if (grid[i][j] == 'E') {
                    count++; // if enemy then increment the count denoting that we have seen one
                } else {
                    // in case of 'W' reset the count since the bomb will not be able to kill
                    count = 0;
                }
            }
        }
        return max;
    }
}
