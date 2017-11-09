package dtprogrammer.github.io.p128;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null) {
            return 0;
        }
        Set<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            numbers.add(num);
        }
        int maxLength = 0;
        for (int num : nums) {
            // if this is the start of sequence
            if (!numbers.contains(num - 1)) {
                int curLength = 1;
                while (numbers.contains(num + 1)) {
                    ++curLength;
                    ++num;
                }
                maxLength = Math.max(maxLength, curLength);
            }
        }
        return maxLength;
    }
}
