package dtprogrammer.github.io.p55;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * For example:
 * A = [2,3,1,1,4], return true.
 * <p>
 * A = [3,2,1,0,4], return false.
 * <p>
 * Time complexity: O(n) since we traverse the array once.
 * Space complexity: O(n) although we are tracking that whether an index is a good index or bad index we don't need
 * to remember all the previous index. If we just remember the last good index and make sure from current index we
 * can reach there then that guarantees we can reach to end. So we can do this in constant space
 */
public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        int lastGoodIndex = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastGoodIndex) {
                lastGoodIndex = i;
            }
        }
        return lastGoodIndex == 0;
    }
}
