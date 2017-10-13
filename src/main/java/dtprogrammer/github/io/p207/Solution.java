package dtprogrammer.github.io.p207;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 207. Course Schedule
 * http://dtprogrammer.github.io/207-course-schedule/
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        int[] adjacency = new int[numCourses];
        Arrays.fill(adjacency, 0);
        // create an graph and adjacency list
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            if (graph[prereq][course] == 0) {
                graph[prereq][course] = 1;
                adjacency[course] += 1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < adjacency.length; i++) {
            if (adjacency[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int curCourseNum = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (graph[curCourseNum][i] == 1) {
                    adjacency[i] -= 1;
                    if (adjacency[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
