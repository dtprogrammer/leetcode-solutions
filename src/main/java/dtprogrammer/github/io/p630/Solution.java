package dtprogrammer.github.io.p630;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int scheduleCourse(int[][] courses) {
        // sort by the closed on day
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        int timeSoFar = 0;
        for (int[] course : courses) {
            timeSoFar += course[0];
            queue.add(course[0]);
            if (course[1] < timeSoFar) {
                timeSoFar -= queue.poll();
            }
        }
        return queue.size();
    }
}
