package dtprogrammer.github.io.p70;

import java.util.Arrays;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * If there is 1 stair then there is only one way to climb it. If there are two stairs then there are two ways.
 * If there are three stairs then the ways is 2 stairs way + one stairs way. So if stairs are n then total ways is
 * ways(n - 1) + ways(n -2)
 * Time complexity: O (n). It is possible to calculate fib in log (n) time.
 * https://kukuruku.co/post/the-nth-fibonacci-number-in-olog-n/
 * Space complexity: O (n). Although we can solve it with O(2) by just keeping track of (n - 1) and (n - 2)
 */
public class Solution {
    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        int[] memo = new int[n];
        Arrays.fill(memo, Integer.MIN_VALUE);

        memo[0] = 1;
        memo[1] = 2;
        for (int i = 3; i <= n; i++) {
            memo[i - 1] = memo[i - 2] + memo[i - 3];
        }
        return memo[memo.length - 1];
    }
}
