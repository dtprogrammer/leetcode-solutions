package dtprogrammer.github.io.p200;

/**
 * 200.Number of Islands
 */
public class Solution {
    private static int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    countIslands(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    private void countIslands(char[][] grid, int row, int col) {
        // out of boundary of grid
        if (grid[row][col] == '1') {
            grid[row][col] = '0';
            for (int[] direction : DIRECTIONS) {
                if (row + direction[0] >= 0 && row + direction[0] < grid.length &&
                        col + direction[1] >= 0 && col + direction[1] < grid[row].length &&
                        grid[row + direction[0]][col + direction[1]] == '1') {
                    countIslands(grid, row + direction[0], col + direction[1]);
                }
            }
        }
    }
}
