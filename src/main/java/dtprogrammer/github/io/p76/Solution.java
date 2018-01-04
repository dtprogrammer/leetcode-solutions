package dtprogrammer.github.io.p76;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> charCounts = new HashMap<>();
        // init the map
        for (char c : s.toCharArray()) {
            charCounts.put(c, 0);
        }

        // set the char counts for expected
        for (char c : t.toCharArray()) {
            if (charCounts.containsKey(c)) {
                charCounts.put(c, charCounts.get(c) + 1);
            } else {
                return "";
            }
        }

        int start = 0, end = 0, minLength = Integer.MAX_VALUE, windowStart = 0, counter = t.length();

        while (end < s.length()) {
            char curChar = s.charAt(end);
            if (charCounts.get(curChar) > 0) {
                counter--;
            }
            charCounts.put(curChar, charCounts.get(curChar) - 1);
            end++;

            while (counter == 0) {
                // update the window if this is the largest window
                if(end - start < minLength) {
                    windowStart = start;
                    minLength = end - start;
                }

                // try to shrink the window
                curChar = s.charAt(start);
                if (charCounts.get(curChar) == 0) {
                    counter++;
                }
                charCounts.put(curChar, charCounts.get(curChar) + 1);
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(windowStart, windowStart + minLength);
    }
}
