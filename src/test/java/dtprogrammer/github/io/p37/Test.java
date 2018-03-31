package dtprogrammer.github.io.p37;

import org.junit.Assert;

import java.util.Arrays;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        char[][] board = new char[][]{
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
        char[][] solvedBoard = new char[][]{
                {'5', '1', '9', '7', '4', '8', '6', '3', '2'},
                {'7', '8', '3', '6', '5', '2', '4', '1', '9'},
                {'4', '2', '6', '1', '3', '9', '8', '7', '5'},
                {'3', '5', '7', '9', '8', '6', '2', '4', '1'},
                {'2', '6', '4', '3', '1', '7', '5', '9', '8'},
                {'1', '9', '8', '5', '2', '4', '3', '6', '7'},
                {'9', '7', '5', '8', '6', '3', '1', '2', '4'},
                {'8', '3', '2', '4', '9', '1', '7', '5', '6'},
                {'6', '4', '1', '2', '7', '5', '9', '8', '3'}};
        solution.solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            Assert.assertTrue(Arrays.equals(board[i], solvedBoard[i]));
        }
    }
}
