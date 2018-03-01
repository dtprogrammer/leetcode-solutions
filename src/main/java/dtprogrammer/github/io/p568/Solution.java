package dtprogrammer.github.io.p568;

import java.util.Arrays;

/**
 * 568. Maximum Vacation Days
 */
public class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        if (flights == null || days == null || flights.length == 0 || flights[0].length == 0 ||
                days.length == 0 || days[0].length == 0) {
            return 0;
        }
        int[][] memo = new int[flights.length][days[0].length];
        for (int[] ints : memo) {
            Arrays.fill(ints, Integer.MIN_VALUE);
        }
        return dfs(flights, days, memo, 0, 0);
    }

    private int dfs(int[][] flights, int[][] days, int[][] memo, int curCity, int curWeek) {
        if (curWeek == days[0].length) {
            return 0;
        }
        if (memo[curCity][curWeek] != Integer.MIN_VALUE) {
            return memo[curCity][curWeek];
        }
        int maxVacationDays = 0;
        for (int i = 0; i < flights.length; i++) {
            if (flights[curCity][i] == 1 || i == curCity) {
                int vacationDays = days[i][curWeek] + dfs(flights, days, memo, i, curWeek + 1);
                maxVacationDays = Math.max(maxVacationDays, vacationDays);
            }
        }
        memo[curCity][curWeek] = maxVacationDays;
        return maxVacationDays;
    }
}
