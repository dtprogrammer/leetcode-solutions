package dtprogrammer.github.io.p322;

/**
 * 322. Coin Change
 * http://dtprogrammer.github.io/322-coin-change/
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        // memoization array
        int[] memo = new int[amount + 1];
        memo[0] = 0; // there is 0 ways of coin to get a sum 0

        for (int i = 1; i <= amount; i++) {
            int min = -1; // initial value: we assume there is no solution
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && memo[i - coins[j]] != -1) { // if coin is not larger than the amount itself
                    // and there exists a solution for it
                    // if this is the first time just use the calculated value else look for minimum
                    min = min < 0 ? memo[i - coins[j]] + 1 : Math.min(min, memo[i - coins[j]] + 1);
                }
            }
            // store the final calculated minimum for the amount
            memo[i] = min;
        }
        return memo[amount];
    }
}
