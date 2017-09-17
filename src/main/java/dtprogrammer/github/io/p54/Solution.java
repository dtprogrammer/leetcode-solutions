package dtprogrammer.github.io.p54;

import java.util.LinkedList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * http://dtprogrammer.github.io/54-spiral-matrix/
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int rowBegin = 0;
        int rowEnd = matrix.length;
        int colBegin = 0;
        int colEnd = matrix[0].length;


        while (rowBegin < rowEnd && colBegin < colEnd) {
            for (int j = colBegin; j < colEnd; j++) {
                result.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            for (int i = rowBegin; i < rowEnd; i++) {
                result.add(matrix[i][colEnd - 1]);
            }
            colEnd--;
            if (rowBegin < rowEnd) {
                for (int j = colEnd - 1; j >= colBegin; j--) {
                    result.add(matrix[rowEnd - 1][j]);
                }
            }
            rowEnd--;

            if (colBegin < colEnd) {
                for (int i = rowEnd - 1; i >= rowBegin; i--) {
                    result.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        return result;
    }
}
