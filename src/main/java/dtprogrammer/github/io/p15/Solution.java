package dtprogrammer.github.io.p15;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 15. 3Sum
 * <p>
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique
 * triplets in the array which gives the sum of zero.
 * <p>
 * Note: The solution set must not contain duplicate triplets.
 * <p>
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * Time complexity: O(n2)
 * Space complexity: constant
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        // sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // skip if this number is equal to the previous since we already process its triplet
            if (i == 0 || nums[i] != nums[i - 1]) {
                int targetSum = 0 - nums[i];
                int low = i + 1;
                int high = nums.length - 1;

                while (low < high) {
                    if (nums[low] + nums[high] == targetSum) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        // handle duplicates
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                    }
                    if (nums[low] + nums[high] < targetSum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }

        }
        return result;
    }
}
