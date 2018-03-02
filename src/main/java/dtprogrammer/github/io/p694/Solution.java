package dtprogrammer.github.io.p694;

import java.util.*;

/**
 * 694. Number of Distinct Islands
 */
public class Solution {

    private static int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numDistinctIslands(int[][] grid) {
        Set<List<List<Integer>>> distinctIslands = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    List<List<Integer>> coordinates = new ArrayList<>();
                    countIslands(grid, i, j, i, j, coordinates);
                    if (!coordinates.isEmpty()) {
                        distinctIslands.add(coordinates);
                    }
                }
            }
        }
        return distinctIslands.size();
    }

    private void countIslands(int[][] grid, int islandRow, int islandCol, int row, int col,
                              List<List<Integer>> coordinates) {
        // out of boundary of grid
        if (grid[row][col] == 1) {
            coordinates.add(Arrays.asList(row - islandRow, col - islandCol));
            grid[row][col] = 0;
            for (int[] direction : DIRECTIONS) {
                if (row + direction[0] >= 0 && row + direction[0] < grid.length &&
                        col + direction[1] >= 0 && col + direction[1] < grid[row].length &&
                        grid[row + direction[0]][col + direction[1]] == 1) {
                    countIslands(grid, islandRow, islandCol, row + direction[0], col + direction[1],
                            coordinates);
                }
            }
        }
    }
}
