package dtprogrammer.github.io.p253;

import dtprogrammer.github.io.common.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] find the
 * minimum number of conference rooms required.
 * Time complexity: O (n log n)
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0] == null) {
            return 0;
        }

        // sort the meeting by starting time
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });


        // min heap for intervals based on the meeting end time
        PriorityQueue<Interval> queue = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.end, o2.end);
            }
        });

        queue.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            Interval current = queue.poll();

            if (current.end <= intervals[i].start) {
                current.end = intervals[i].end;
            } else {
                queue.offer(intervals[i]);
            }
            queue.offer(current);
        }
        return queue.size();
    }
}
