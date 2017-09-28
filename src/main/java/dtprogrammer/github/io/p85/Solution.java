package dtprogrammer.github.io.p85;

import java.util.Arrays;

/**
 * 85. Maximal Rectangle
 * http://dtprogrammer.github.io/85-maximal-rectangle/
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] left = new int[cols], right = new int[cols], height = new int[cols];
        Arrays.fill(left, 0);
        Arrays.fill(right, cols);
        Arrays.fill(height, 0);

        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            int curLeft = 0, curRight = cols;
            // calculate the height
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            // calculate the left boundary
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }

            // calculate the right boundary
            for (int j = cols - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = cols;
                    curRight = j;
                }
            }

            // calculate the area;
            for (int j = 0; j < cols; j++) {
                maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
            }
        }
        return maxArea;
    }
}
