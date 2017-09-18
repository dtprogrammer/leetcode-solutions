package dtprogrammer.github.io.p46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 46. Permutations
 * http://dtprogrammer.github.io/46-permutations/
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        permute(result, new Stack<Integer>(), nums);
        return result;
    }

    private void permute(List<List<Integer>> result, Stack<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.push(nums[i]);
            permute(result, tempList, nums);
            tempList.pop();
        }
    }
}
