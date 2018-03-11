package dtprogrammer.github.io.p136;

import java.util.Arrays;

/**
 * 136. Single Number
 */
public class Solution {
    public int singleNumber(int[] nums) {
        final int[] notRepeated = {0};
        Arrays.stream(nums).forEach(x -> notRepeated[0] ^= x);
        return notRepeated[0];
    }
}
