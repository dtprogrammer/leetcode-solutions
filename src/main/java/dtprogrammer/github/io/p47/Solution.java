package dtprogrammer.github.io.p47;

import java.util.*;

/**
 * 47. Permutations II
 * http://dtprogrammer.github.io/47-permutations-ii/
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        permuteUnique(result, new Stack<Integer>(), nums, used);
        return result;
    }

    private void permuteUnique(List<List<Integer>> result, Stack<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            tempList.push(nums[i]);
            used[i] = true;
            permuteUnique(result, tempList, nums, used);
            tempList.pop();
            used[i] = false;
        }
    }
}
