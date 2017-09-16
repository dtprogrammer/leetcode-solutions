package dtprogrammer.github.io.p73;

/**
 * 73. Set matrix zeroes
 * http://dtprogrammer.github.io/73-set-matrix-zeroes/
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int col0 = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                col0 = 0;
            }
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[i].length - 1; j >= 1; j--) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
            matrix[i][0] = col0 == 0 ? 0 : matrix[i][0];
        }
    }
}
