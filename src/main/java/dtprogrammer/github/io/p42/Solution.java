package dtprogrammer.github.io.p42;

/**
 * 42. Trapping Rain Water
 * http://dtprogrammer.github.io/42-trapping-rain-water/
 */
public class Solution {
    public int trap(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int leftMax = 0, rightMax = 0, left = 0, right = height.length - 1, totalWater = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                // update left
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                // update right
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }
}
