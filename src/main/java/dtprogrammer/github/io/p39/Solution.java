package dtprogrammer.github.io.p39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 39. Combination Sum
 * http://dtprogrammer.github.io/39-combination-sum/
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> validCombinations = new LinkedList<>();
        combinationSum(candidates, target, new Stack<Integer>(), 0, validCombinations);
        return validCombinations;
    }

    private void combinationSum(int[] candidates, int remaining, Stack<Integer> curCombination, int start,
                                List<List<Integer>> validCombinations) {
        if (0 >= remaining || start >= candidates.length) {
            if (0 == remaining) {
                validCombinations.add(new ArrayList<>(curCombination));
            }
            return;
        }
        // subset including this number and start and not start + 1 since number can be reused
        curCombination.push(candidates[start]);
        combinationSum(candidates, remaining - candidates[start], curCombination, start, validCombinations);
        curCombination.pop();
        // subset skipping this number so start + 1
        combinationSum(candidates, remaining, curCombination, start + 1, validCombinations);
    }
}
