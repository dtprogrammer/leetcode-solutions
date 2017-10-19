package dtprogrammer.github.io.p210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> coursePrequisite = new ArrayList<>();
        int[] totalPrequisities = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            coursePrequisite.add(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            // represents that after taking 1 you can take course 0 if the pair is [0, 1]
            coursePrequisite.get(prerequisite[1]).add(prerequisite[0]);
            totalPrequisities[prerequisite[0]] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < totalPrequisities.length; i++) {
            if (totalPrequisities[i] == 0) {
                queue.add(i);
            }
        }

        int[] order = new int[numCourses];
        int visitedCourses = 0;
        while (!queue.isEmpty()) {
            int feasibleCourse = queue.poll();
            order[visitedCourses] = feasibleCourse;
            visitedCourses++;
            for (int i = 0; i < coursePrequisite.get(feasibleCourse).size(); i++) {
                totalPrequisities[coursePrequisite.get(feasibleCourse).get(i)] -= 1;
                if (totalPrequisities[coursePrequisite.get(feasibleCourse).get(i)] == 0) {
                    queue.add(coursePrequisite.get(feasibleCourse).get(i));
                }
            }
        }
        return numCourses == visitedCourses ? order : new int[0];
    }
}
