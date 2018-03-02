package dtprogrammer.github.io.p252;

import dtprogrammer.github.io.common.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 * <p>
 * For example, Given [[0, 30],[5, 10],[15, 20]], return false.
 * Definition for an interval.
 * struct Interval {
 * int start;
 * int end;
 * Interval() : start(0), end(0) {}
 * Interval(int s, int e) : start(s), end(e) {}
 * };
 * <p>
 * Time complexity: O (n log n) to sort the array. After that O(n) to process. We can try to optimize the time by
 * trading it off with space. We can use a priority queue to store the events by the finish time. Although the
 * insertion in priority queue has O (log n) complexity making the complexity O (n log n) overall.
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {

        if (intervals == null || intervals.length == 0 || intervals[0] == null) {
            return true;
        }

        // sort the array with the finish time
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.end, o2.end);
            }
        });

        // the person cannot make to all the meeting if the current meeting finishes after the next meeting start time
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }
        return true;
    }
}
