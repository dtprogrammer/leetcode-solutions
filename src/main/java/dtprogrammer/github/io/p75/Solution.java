package dtprogrammer.github.io.p75;

/**
 * 75. Sort Colors
 * http://dtprogrammer.github.io/75-sort-colors/
 */
public class Solution {
    public void sortColors(int[] nums) {
        if (nums != null) {
            int lower = 0, equal = 0, higher = nums.length - 1;

            // consider white (1) as middle and the pivot value
            while (equal <= higher) {
                if (nums[equal] < 1) {
                    swap(nums, lower++, equal++);
                } else if (nums[equal] == 1) {
                    equal++;
                } else {
                    swap(nums, equal, higher--);
                }
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
