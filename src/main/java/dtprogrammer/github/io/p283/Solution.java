package dtprogrammer.github.io.p283;

import java.util.Arrays;

/**
 * 283. Move Zeroes
 * http://dtprogrammer.github.io/283-move-zeroes/
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int writeLocation = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != writeLocation) {
                    nums[writeLocation] = nums[i];
                }
                writeLocation++;
            }
        }
        Arrays.fill(nums, writeLocation, nums.length, 0);
    }
}
