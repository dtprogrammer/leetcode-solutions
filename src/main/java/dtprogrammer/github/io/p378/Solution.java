package dtprogrammer.github.io.p378;

import java.util.PriorityQueue;

/**
 * http://dtprogrammer.github.io/378-kth-smallest-element-in-a-sorted-matrix/
 * 378. Kth Smallest Element in a Sorted Matrix
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<MatrixElementWithPosition> heap = new PriorityQueue<>();

        // init the heap with
        for (int i = 0; i < matrix[0].length; i++) {
            heap.offer(new MatrixElementWithPosition(matrix[0][i], 0, i));
        }

        MatrixElementWithPosition curLowest = null;
        while (k > 0) {
            // replace from heap
            curLowest = heap.poll();
            k--;
            // if we are in the last row there is no more data to add now
            if (curLowest.row == matrix.length - 1) {
                continue;
            }
            heap.offer(new MatrixElementWithPosition(matrix[curLowest.row + 1][curLowest.col], curLowest.row + 1,
                    curLowest.col));

        }
        return curLowest.val;
    }

    private class MatrixElementWithPosition implements Comparable<MatrixElementWithPosition> {
        int val, row, col;

        MatrixElementWithPosition(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(MatrixElementWithPosition o) {
            return Integer.compare(this.val, o.val);
        }
    }
}
