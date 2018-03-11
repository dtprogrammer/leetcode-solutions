package dtprogrammer.github.io.p220;

import java.util.HashMap;
import java.util.Map;

/**
 * 220. Contains Duplicate III
 */
public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0 || k < 1) return false;
        long w = t + 1;
        Map<Long, Long> bucketToNumbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedValue = (long) nums[i] - Integer.MIN_VALUE;
            long b = remappedValue / w;
            if (bucketToNumbers.containsKey(b) ||
                    (bucketToNumbers.containsKey(b - 1) && Math.abs(bucketToNumbers.get(b - 1) - remappedValue) < w) ||
                    bucketToNumbers.containsKey(b + 1) && Math.abs(bucketToNumbers.get(b + 1) - remappedValue) < w) {
                return true;
            }
            bucketToNumbers.put(b, remappedValue);
            if (i >= k) {
                bucketToNumbers.remove(((long) nums[i - k] - Integer.MIN_VALUE) / w);
            }
        }
        return false;
    }
}
