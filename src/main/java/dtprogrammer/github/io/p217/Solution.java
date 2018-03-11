package dtprogrammer.github.io.p217;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            numbers.add(num);
        }
        return nums.length != numbers.size();
    }
}
