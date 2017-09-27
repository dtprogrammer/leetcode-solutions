package dtprogrammer.github.io.p300;

import java.util.Arrays;
import java.util.Collections;

/**
 * 300. Longest Increasing Subsequence
 * http://dtprogrammer.github.io/300-longest-increasing-subsequence/
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = 1;    // the longest at this point is the element itself
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }
        return memo.length == 0 ? 0 : Collections.max(Arrays.asList(memo));
    }

    //TODO: Do a n log (n) solution
}
