package dtprogrammer.github.io.p621;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 621. Task Scheduler
 * <p>
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 * <p>
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
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
 * <p>
 * Time complexity : O(n)O(n). Number of iterations will be equal to resultant time timetime.
 * <p>
 * Space complexity : O(1)O(1). queue and temp size will not exceed O(26).
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        // task to task count map
        int[] taskCounts = new int[26];

        for (char task : tasks) {
            taskCounts[task - 'A']++;
        }

        // initialize the priority queue with all tasks
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());

        for (int taskCount : taskCounts) {
            if (taskCount > 0) {
                queue.offer(taskCount);
            }
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List<Integer> afterCoolOffTasks = new LinkedList<>();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    // take the task with most number of instance
                    Integer currentTask = queue.peek();
                    // remove the instance of task from the queue
                    if (currentTask > 1) {
                        afterCoolOffTasks.add(queue.poll() - 1);
                    } else {
                        queue.poll();
                    }
                }
                time++; // time instance increment marking the task to be done
                i++;
                if (queue.isEmpty() && afterCoolOffTasks.size() == 0) {
                    break;
                }
            }
            // cool off period done. add the after cool of tasks back to queue
            for (Integer afterCoolOffTask : afterCoolOffTasks) {
                queue.offer(afterCoolOffTask);
            }
        }
        return time;
    }
}
