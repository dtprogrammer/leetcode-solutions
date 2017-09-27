package dtprogrammer.github.io.p221;

/**
 * 221. Maximal Square
 * http://dtprogrammer.github.io/221-maximal-square/
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxSide = 0, prev = 0;
        int[] memo = new int[matrix[0].length + 1]; // we only need to track the memo of previous row for current
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) { // first row and column does not mean anything as they
                // cannot form square on themselves. we also need to process the last rows and column with i - 1 and
                // j - 1 in matrix
                int temp = memo[j]; // keeping track for previous upper corner
                if (matrix[i - 1][j - 1] == '1') {
                    memo[j] = Math.min(Math.min(prev, memo[j - 1]), memo[j]) + 1;
                    maxSide = Math.max(maxSide, memo[j]);
                } else {
                    // here we specifically need to reset to 0 as for previous row this column might not have 0 and
                    // the value might be been calculated. Hence clean it out to 0
                    memo[j] = 0;
                }
                prev = temp;
            }
        }
        return maxSide * maxSide; // area of square
    }
}
