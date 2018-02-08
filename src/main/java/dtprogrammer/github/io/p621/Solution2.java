package dtprogrammer.github.io.p621;

import java.util.Arrays;

/**
 * 621. Task Scheduler
 * <p>
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters
 * represent different tasks.Tasks could be done without original order. Each task could be done in one interval.
 * For each interval, CPU could finish one task or just be idle.
 * <p>
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n
 * intervals that CPU are doing different tasks or just be idle.
 * <p>
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * <p>
 * Example 1:
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * Note:
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 * Time complexity : O(n)O(n). We iterate over tasks array only once. (O(n)O(n)).Sorting tasks array of
 * length nn takes O\big(26log(26)\big)= O(1)O(26log(26))=O(1) time. After this, only one iteration over 26 elements
 * of map is done(O(1)O(1).
 * <p>
 * Space complexity : O(1)O(1). map array of constant size(26) is used.
 */
public class Solution2 {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCounts = new int[26];

        for (char task : tasks) {
            taskCounts[task - 'A']++;
        }

        Arrays.sort(taskCounts);

        int maxTaskInstancesWithIdleSlots = taskCounts[25] - 1;
        int maxIdleSlots = maxTaskInstancesWithIdleSlots * n;

        for (int i = 24; i >= 0; i--) {
            maxIdleSlots -= Math.min(maxTaskInstancesWithIdleSlots, taskCounts[i]);
        }
        return maxIdleSlots > 0 ? tasks.length + maxIdleSlots : tasks.length;
    }
}
