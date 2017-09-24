package dtprogrammer.github.io.p152;

/**
 * 152. Maximum Product Subarray
 * http://dtprogrammer.github.io/152-maximum-product-subarray/
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0], maxEndingHere = nums[0], minEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // if we see a negative number then swap the current max and min since
            // after being multiplied by a negative number min will become max and max will become min
            if (nums[i] < 0) {
                int temp = maxEndingHere;
                maxEndingHere = minEndingHere;
                minEndingHere = temp;
            }
            maxEndingHere = Math.max(maxEndingHere * nums[i], nums[i]);
            minEndingHere = Math.min(minEndingHere * nums[i], nums[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }
}
