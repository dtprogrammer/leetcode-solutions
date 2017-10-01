package dtprogrammer.github.io.p287;

/**
 * 287. Find the Duplicate Number
 * http://dtprogrammer.github.io/287-find-the-duplicate-number/
 */
public class Solution2 {
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midUnder = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    midUnder++;
                }
            }
            if (midUnder > mid) {
                // duplicate is between low and mid
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
