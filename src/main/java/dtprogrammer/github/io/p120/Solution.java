package dtprogrammer.github.io.p120;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on
 * the row below.
 * <p>
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * <p>
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in
 * the triangle.
 * <p>
 * Time complexity: O (m * n)
 * Space complexity: O (n)
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return Integer.MAX_VALUE;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        List<Integer> memo = new ArrayList<>(triangle.get(triangle.size() - 1));
        System.out.println(memo);


        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                memo.set(j, (triangle.get(i).get(j) + Math.min(memo.get(j), memo.get(j + 1))));
            }
        }
        return memo.get(0);
    }
}
