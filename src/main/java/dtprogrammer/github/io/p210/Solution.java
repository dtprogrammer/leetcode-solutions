package dtprogrammer.github.io.p210;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] coursePrequisite = new int[numCourses][numCourses];
        int[] totalPrequisities = new int[numCourses];
        Arrays.fill(totalPrequisities, 0);
        for (int[] prerequisite : prerequisites) {
            // represents that after taking 1 you can take course 0 if the pair is [0, 1]
            coursePrequisite[prerequisite[1]][prerequisite[0]] = 1;
            totalPrequisities[prerequisite[0]] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < totalPrequisities.length; i++) {
            if(totalPrequisities[i] == 0) {
                queue.add(i);
            }
        }

        int[] order = new int[numCourses];
        int visitedCourses = 0;
        while(!queue.isEmpty()) {
            int feasibleCourse = queue.poll();
            order[visitedCourses] = feasibleCourse;
            visitedCourses++;
            for (int i = 0; i < numCourses; i++) {
                if(coursePrequisite[feasibleCourse][i] == 1) {
                    totalPrequisities[i] -= 1;
                    if(totalPrequisities[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }
        return numCourses == visitedCourses ? order : new int[0];
    }
}
