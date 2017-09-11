package dtprogrammer.github.io.p36;

import java.util.Arrays;

/**
 * 36. Valid Sudoku
 * <p>
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * <p>
 * <p>
 * A partially filled sudoku which is valid.
 * <p>
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * <p>
 * Time complexity: O(n pow 2)
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // if the board if not valid fail early
        if (board == null || board.length == 0 || board[0].length == 0 || board.length != board[0].length) {
            return false;
        }

        // validate rows
        for (int i = 0; i < board.length; i++) {
            if (!valid(board, i, i + 1, 0, board[i].length)) {
                return false;
            }
        }

        // validate columns
        for (int i = 0; i < board[0].length; i++) {
            if (!valid(board, 0, board.length, i, i + 1)) {
                return false;
            }
        }
        // smaller square size
        int smallerSquare = (int) Math.sqrt(board.length);
        for (int row = 0; row < smallerSquare; row++) {
            for (int col = 0; col < smallerSquare; col++) {
                if (!valid(board, smallerSquare * row, smallerSquare * row + smallerSquare,
                        smallerSquare * col, smallerSquare * col + smallerSquare)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean valid(char[][] board, int startRow, int endRow, int startCol, int endCol) {
        Boolean[] present = new Boolean[board.length];
        Arrays.fill(present, false);

        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                if (board[i][j] != '.') {
                    if (present[Character.getNumericValue(board[i][j]) - 1]) {
                        return false;
                    } else {
                        present[Character.getNumericValue(board[i][j]) - 1] = true;
                    }
                }
            }
        }
        return true;
    }
}
