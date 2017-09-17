package dtprogrammer.github.io.p56;

import dtprogrammer.github.io.common.Interval;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 56. Merge Intervals
 * http://dtprogrammer.github.io/56-merge-intervals/
 */
public class Solution {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            return mergedIntervals;
        }

        // sort the intervals on basis of the start time
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });

        // merge them
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= end) {
                end = Math.max(end, intervals.get(i).end);
            } else {
                mergedIntervals.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        mergedIntervals.add(new Interval(start, end));
        return mergedIntervals;
    }
}
