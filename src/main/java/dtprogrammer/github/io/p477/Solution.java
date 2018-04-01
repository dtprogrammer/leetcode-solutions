package dtprogrammer.github.io.p477;

public class Solution {
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int setBitCount = 0;
            for (int j = 0; j < nums.length; j++) {
                setBitCount += (nums[j] >> i) & 1;
            }
            result += setBitCount * (nums.length - setBitCount);
        }
        return result;
    }
}
