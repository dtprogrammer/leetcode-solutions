package dtprogrammer.github.io.p74;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * <h1>Solution</h1>
 * We can treat the 2D array as a single dimension array since 2D array are represented as single dimension arrays
 * itself in memory. We use the array width to calculate the row and col to look for.
 * <h3>Time complexity</h3>
 * We are using binary search so time complexity is 0 log (m*n)
 * <h3>Space complexity</h3>
 * The space complexity is O(1) although some space is taken by the recursion stack trace. It is possible to use
 * iterative implementation of binary search and avoid using this space too.
 */
class Solution {
    boolean searchMatrix(int[][] matrix, int target) {
        // if the 2d array is empty then return false
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return search(matrix, 0, matrix.length * matrix[0].length - 1, target);
    }

    private boolean search(int[][] matrix, int low, int high, int target) {
        if (low > high) {
            return false;   // base condition
        }
        // calculate mid
        int mid = low + (high - low) / 2;

        // In the example array shown above. If the  mid is 6 then  in the 2d array we will want to see the element at
        // element at [1][2]
        int row = mid / matrix[0].length; // 6 / 4 = 1
        int col = mid % matrix[0].length; // 6 % 4 = 2


        // typical binary search
        if (matrix[row][col] == target) {
            return true;
        } else if (matrix[row][col] < target) {
            return search(matrix, mid + 1, high, target);
        } else {
            return search(matrix, low, mid - 1, target);
        }
    }
}