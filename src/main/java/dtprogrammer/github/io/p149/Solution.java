package dtprogrammer.github.io.p149;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/max-points-on-a-line/description/
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }

        Map<Integer, Map<Integer, Integer>> slopeCounts = new HashMap<>();
        int result = 0;
        for (int i = 0; i < points.length - 1; i++) {
            slopeCounts.clear();
            int samePoints = 0, curMax = 0;
            for (int j = i + 1; j < points.length; j++) {

                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    samePoints++;
                } else {
                    // calculate the slope between two points
                    int x = points[j].x - points[i].x;
                    int y = points[j].y - points[i].y;

                    // divide the gcd to store in map
                    int gcd = calculateGCD(x, y);
                    if (gcd != 0) {
                        x /= gcd;
                        y /= gcd;
                    }

                    Map<Integer, Integer> xData;
                    if (slopeCounts.containsKey(x)) {
                        xData = slopeCounts.get(x);
                    } else {
                        xData = new HashMap<>();
                    }
                    xData.put(y, xData.getOrDefault(y, 0) + 1);
                    slopeCounts.put(x, xData);
                    curMax = Math.max(curMax, xData.get(y));
                }
            }
            result = Math.max(result, curMax + samePoints + 1);
        }
        return result;
    }

    private int calculateGCD(int x, int y) {
        if (y == 0) {
            return x;
        }
        return calculateGCD(y, x % y);
    }

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
