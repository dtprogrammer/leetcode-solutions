package dtprogrammer.github.io.p78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 78. Subsets
 * http://dtprogrammer.github.io/78-subsets/
 */
public class StackBasedSolution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        subsets(result, new Stack<Integer>(), nums, 0);
        return result;
    }

    private void subsets(List<List<Integer>> result, Stack<Integer> tempList, int[] nums, int start) {
        // base condition
        if (nums.length == start) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        // nums[start] take part
        tempList.push(nums[start]);
        subsets(result, tempList, nums, start + 1);

        // nums[start] does not take part
        tempList.pop();
        subsets(result, tempList, nums, start + 1);

    }
}
