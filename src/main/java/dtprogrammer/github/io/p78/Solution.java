package dtprogrammer.github.io.p78;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * http://dtprogrammer.github.io/78-subsets/
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsetsHelper(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }

    private void subsetsHelper(List<List<Integer>> result, ArrayList<Integer> tempList, int[] nums, int cur) {
        result.add(new ArrayList<>(tempList));
        for (int i = cur; i < nums.length; i++) {
            tempList.add(nums[i]);
            subsetsHelper(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
