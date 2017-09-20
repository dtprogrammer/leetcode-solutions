package dtprogrammer.github.io.p52;

public class Solution {
    public int totalNQueens(int n) {
        int[] solutions = {0}; // number of solutions. stored in array to retain value across recursive calls
        totalNQueens(n, 0, new boolean[n], new boolean[n * 2], new boolean[n * 2], solutions);
        return solutions[0];
    }

    private void totalNQueens(int n, int curRow, boolean[] columns, boolean[] diagonal1, boolean[] diagonal2,
                              int[] solutions) {
        if (curRow == n) {
            solutions[0]++;
            return;
        }
        for (int col = 0; col < n; col++) {
            // columns keep track of the column and diagonal 1 and 2 the diagonals
            if (columns[col] || diagonal1[col + curRow] || diagonal2[col - curRow + n]) {
                continue;
            }
            columns[col] = diagonal1[col + curRow] = diagonal2[col - curRow + n] = true;
            totalNQueens(n, curRow + 1, columns, diagonal1, diagonal2, solutions);
            columns[col] = diagonal1[col + curRow] = diagonal2[col - curRow + n] = false;
        }
    }
}
