package dtprogrammer.github.io.p34;

import java.util.Arrays;

/**
 * 34. Search for a Range
 * <p>
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * Time complexity: O (log n)
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] resultIndexes = new int[2];
        Arrays.fill(resultIndexes, -1);
        if (nums == null || nums.length == 0) {
            return resultIndexes;
        }

        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        if (nums[low] != target) {
            return resultIndexes;
        }
        resultIndexes[0] = low;

        high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2 + 1;
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        resultIndexes[1] = high;
        return resultIndexes;
    }
}
