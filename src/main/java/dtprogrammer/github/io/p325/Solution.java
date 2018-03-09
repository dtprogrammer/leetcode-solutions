package dtprogrammer.github.io.p325;

import java.util.HashMap;
import java.util.Map;

/**
 * 325. Maximum Size Subarray Sum Equals k
 */
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> sumToIndex = new HashMap<>();
        int sum = 0, maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                //|_____________|            |
                maxLength = i + 1;
            } else if (sumToIndex.containsKey(sum - k)) {
                //|             |_____________|                 |
                maxLength = Math.max(maxLength, i - sumToIndex.get(sum - k));
            }
            if (!sumToIndex.containsKey(sum)) {
                // we only store i if it does not exists to retain the lowest value of i so that we
                // get largest window size
                sumToIndex.put(sum, i);
            }
        }
        return maxLength;
    }
}
