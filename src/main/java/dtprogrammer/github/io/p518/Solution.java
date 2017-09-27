package dtprogrammer.github.io.p518;

import java.util.Arrays;

/**
 * 518. Coin Change 2
 * http://dtprogrammer.github.io/518-coin-change-2/
 */
public class Solution {
    public int change(int amount, int[] coins) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, 0);
        memo[0] = 1;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    memo[i] += memo[i - coin];
                }
            }
        }
        return memo[amount];
    }
}
