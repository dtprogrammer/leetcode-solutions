package dtprogrammer.github.io.p90;

import java.util.*;

/**
 * 90. Subsets II
 * http://dtprogrammer.github.io/90-subsets-ii/
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Set<List<Integer>> processed = new HashSet<>();
        Arrays.sort(nums);
        subsetsWithDupHelper(result, new Stack<Integer>(), nums, 0, processed);
        return result;
    }

    private void subsetsWithDupHelper(List<List<Integer>> result, Stack<Integer> tempList, int[] nums, int start,
                                      Set<List<Integer>> processed) {
        if (start == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        tempList.push(nums[start]);
        ArrayList<Integer> copy = new ArrayList<>(tempList);
        if (!processed.contains(copy)) {
            processed.add(copy);
            subsetsWithDupHelper(result, tempList, nums, start + 1, processed);
        }

        tempList.pop();

        subsetsWithDupHelper(result, tempList, nums, start + 1, processed);
    }
}
