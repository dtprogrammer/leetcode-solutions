package dtprogrammer.github.io.p37;

/**
 * 37. Sudoku Solver
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        // validate the board
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || board.length != board[0]
                .length) {
            return;
        }

        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= Character.forDigit(board.length, 10); k++) {
                        if (valid(board, i, j, k)) {
                            board[i][j] = k;

                            if (solve(board)) {  // recursively solve the remaining board
                                return true;
                            } else {
                                board[i][j] = '.'; // go back
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean valid(char[][] board, int row, int col, char proposedValue) {
        int bSqSize = (int) Math.sqrt(board.length);
        for (int i = 0; i < board.length; i++) {
            // validate row
            if (board[row][i] != '.' && board[row][i] == proposedValue) return false;
            // validate col
            if (board[i][col] != '.' && board[i][col] == proposedValue) return false;
            // validate square
            if ((board[bSqSize * (row / bSqSize) + i / bSqSize][bSqSize * (col / bSqSize) + i % bSqSize] != '.' &&
                    board[bSqSize * (row / bSqSize) + i / bSqSize][bSqSize * (col / bSqSize) + i % bSqSize] == proposedValue) ||
                    (board[bSqSize * (row / bSqSize) + i % bSqSize][bSqSize * (col / bSqSize) + i / bSqSize] != '.' &&
                            board[bSqSize * (row / bSqSize) + i % bSqSize][bSqSize * (col / bSqSize) + i / bSqSize] == proposedValue)) {
                return false;
            }
        }
        return true;
    }
}
