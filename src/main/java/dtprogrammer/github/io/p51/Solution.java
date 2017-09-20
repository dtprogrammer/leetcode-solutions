package dtprogrammer.github.io.p51;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 51. N-Queens
 * http://dtprogrammer.github.io/51-n-queens/
 */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> configurations = new LinkedList<>();
        solveNQueens(n, 0, new boolean[n], new boolean[n * 2], new boolean[n * 2], configurations, new
                Stack<String>());
        return configurations;
    }

    private void solveNQueens(int n, int curRow, boolean[] columns, boolean[] diaginal1, boolean[] diagonal2,
                              List<List<String>> configurations, Stack<String> curConfiguration) {
        if (curConfiguration.size() == n) {
            configurations.add(new ArrayList<>(curConfiguration));
            return;
        }
        for (int curCol = 0; curCol < n; curCol++) {
            if (columns[curCol] || diaginal1[curCol + curRow] || diagonal2[curCol - curRow + n]) {
                continue;
            }
            curConfiguration.push(getString(curCol, n));
            columns[curCol] = diaginal1[curCol + curRow] = diagonal2[curCol - curRow + n] = true;
            solveNQueens(n, curRow + 1, columns, diaginal1, diagonal2, configurations, curConfiguration);
            columns[curCol] = diaginal1[curCol + curRow] = diagonal2[curCol - curRow + n] = false;
            curConfiguration.pop();
        }
    }

    private String getString(int curCol, int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == curCol) {
                builder.append("Q");
                continue;
            }
            builder.append(".");
        }
        return builder.toString();
    }
}
