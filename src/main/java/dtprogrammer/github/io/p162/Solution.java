package dtprogrammer.github.io.p162;

/**
 * 162. Find Peak Element
 * http://dtprogrammer.github.io/162-find-peak-element/
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
