package dtprogrammer.github.io.p53;

/**
 * 53. Maximum Subarray
 * http://dtprogrammer.github.io/53-maximum-subarray/
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0], maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }
}
