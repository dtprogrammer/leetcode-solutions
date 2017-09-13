package dtprogrammer.github.io.p130;

public class Solution {
    public void solve(char[][] board) {
        // flip all 0 from borders to *
        if (board != null && board.length != 0) {
            // mark from all boundaries
            // top
            markFromBorder(board, 0, 1, 0, board[0].length);
            // bottom
            markFromBorder(board, board.length - 1, board.length, 0, board[board.length - 1].length);
            // left
            markFromBorder(board, 0, board.length, 0, 1);
            // right
            markFromBorder(board, 0, board.length, board[0].length - 1, board[0].length);

            // now mark all remaining * to O and O to X
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = board[i][j] == '*' ? 'O' : 'X';
                }
            }
        }
    }

    private void markFromBorder(char[][] board, int rowStart, int rowEnd, int colStart, int colEnd) {
        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                markWithNeighbors(board, i, j);
            }
        }
    }

    private void markWithNeighbors(char[][] board, int row, int col) {
        // base case
        if (board[row][col] == 'O') {
            // mark
            board[row][col] = '*';
            // handle neighbors
            if (row > 1) {
                markWithNeighbors(board, row - 1, col);
            }
            if (row + 1 < board.length) {
                markWithNeighbors(board, row + 1, col);
            }
            if (col > 1) {
                markWithNeighbors(board, row, col - 1);
            }
            if (col + 1 < board[row].length) {
                markWithNeighbors(board, row, col + 1);
            }
        }
    }
}
