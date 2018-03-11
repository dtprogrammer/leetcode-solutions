package dtprogrammer.github.io.p539;

import java.util.List;

/**
 * 539. Minimum Time Difference
 */
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        // bucket the times
        boolean[] buckets = new boolean[24 * 60];
        for (String timePoint : timePoints) {
            int hour = (timePoint.charAt(0) - '0') * 10 + (timePoint.charAt(1) - '0');
            int min = (timePoint.charAt(3) - '0') * 10 + (timePoint.charAt(4) - '0');
            int time = hour * 60 + min;
            if (buckets[time]) return 0;
            buckets[time] = true;
        }

        // find the min difference

        int prev = 0, firstTime = Integer.MAX_VALUE, lastTime = Integer.MIN_VALUE, minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i]) {
                if (firstTime != Integer.MAX_VALUE) {
                    minDiff = Math.min(minDiff, i - prev);
                }
                firstTime = Math.min(firstTime, i);
                lastTime = Math.max(lastTime, i);
                prev = i;
            }
        }
        return Math.min(minDiff, (buckets.length - lastTime) + firstTime);
    }
}
