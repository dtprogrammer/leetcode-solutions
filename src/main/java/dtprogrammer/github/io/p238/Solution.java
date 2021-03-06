package dtprogrammer.github.io.p238;

/**
 * 238. Product of Array Except Self
 * http://dtprogrammer.github.io/238-product-of-array-except-self/
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }

        int temp = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = temp * result[i];
            temp = temp * nums[i];
        }
        return result;
    }
}
