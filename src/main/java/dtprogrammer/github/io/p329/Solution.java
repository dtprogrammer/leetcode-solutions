package dtprogrammer.github.io.p329;

public class Solution {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        // memorize the length
        int[][] memo = new int[matrix.length][matrix[0].length];

        int maxLength = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int length = search(matrix, i, j, memo);
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

    private int search(int[][] matrix, int rowIndex, int colIndex, int[][] memo) {
        if (memo[rowIndex][colIndex] != 0) {
            return memo[rowIndex][colIndex];
        }
        int maxLength = 1;
        for (int[] dir : DIRS) {
            int lookAheadRowIndex = rowIndex + dir[0];
            int lookAheadColIndex = colIndex + dir[1];
            if (lookAheadRowIndex < 0 || lookAheadRowIndex >= matrix.length || lookAheadColIndex < 0 ||
                    lookAheadColIndex >= matrix[0].length ||
                    matrix[lookAheadRowIndex][lookAheadColIndex] <= matrix[rowIndex][colIndex]) {
                continue;
            }
            int length = 1 + search(matrix, rowIndex + dir[0], colIndex + dir[1], memo);
            maxLength = Math.max(maxLength, length);
        }
        memo[rowIndex][colIndex] = maxLength;
        return maxLength;
    }
}
