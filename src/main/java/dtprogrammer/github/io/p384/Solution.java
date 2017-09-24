package dtprogrammer.github.io.p384;

import java.util.Random;

/**
 * 384. Shuffle an Array
 * http://dtprogrammer.github.io/384-shuffle-an-array/
 */
public class Solution {
    private final int[] nums;
    private final Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        if (nums == null) {
            return null;
        }
        // use fiher yates algorithm
        final int[] shuffled = nums.clone();
        for (int i = shuffled.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            int temp = shuffled[i];
            shuffled[i] = shuffled[index];
            shuffled[index] = temp;
        }
        return shuffled;
    }
}
