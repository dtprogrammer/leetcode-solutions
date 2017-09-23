package dtprogrammer.github.io.p121;

/**
 * 121. Best Time to Buy and Sell Stock
 * http://dtprogrammer.github.io/121-best-time-to-buy-and-sell-stock/
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, curProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            curProfit = Math.max(curProfit + prices[i] - prices[i - 1], prices[i] - prices[i - 1]);
            maxProfit = Math.max(curProfit, maxProfit);
        }

        return maxProfit;
    }
}
