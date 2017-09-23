package dtprogrammer.github.io.p122;

/**
 * 122. Best Time to Buy and Sell Stock II
 * http://dtprogrammer.github.io/122-best-time-to-buy-and-sell-stock-ii/
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
