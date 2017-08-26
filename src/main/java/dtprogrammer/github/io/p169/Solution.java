package dtprogrammer.github.io.p169;


/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more
 * than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * The simple brute force solution will take O (n2) time. We can also use a HashMap to store the occurrence which
 * will take O(n) time but will also require linear space. Its possible to solve this in linear time and constant
 * space using Boyer's Moore Majority vote algorithm which takes linear time and constant space. For details see:
 * https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
 * Time complexity: O(n)
 * Space complexity: linear
 */
public class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int majorityEle = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majorityEle = nums[i];
            }
            if (nums[i] == majorityEle) {
                count++;
            } else {
                count--;
            }
        }
        return majorityEle;
    }
}
