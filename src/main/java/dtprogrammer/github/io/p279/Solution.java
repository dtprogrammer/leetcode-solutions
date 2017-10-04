package dtprogrammer.github.io.p279;

import java.util.Arrays;

/**
 * 279. Perfect Squares
 * http://dtprogrammer.github.io/279-perfect-squares/
 */
public class Solution {
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] memo = new int[n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                memo[i] = Math.min(memo[i], memo[i - j * j] + 1);
            }
        }
        return memo[n];
    }
}
