package dtprogrammer.github.io.p198;

/**
 * 198. House Robber
 * http://dtprogrammer.github.io/198-house-robber/
 */
public class Solution {
    public int rob(int[] nums) {
        int maxOdd = 0, maxEven = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                maxEven = Math.max(maxOdd, maxEven + nums[i]);
            } else {
                maxOdd = Math.max(maxEven, maxOdd + nums[i]);
            }
        }
        return Math.max(maxOdd, maxEven);
    }
}
