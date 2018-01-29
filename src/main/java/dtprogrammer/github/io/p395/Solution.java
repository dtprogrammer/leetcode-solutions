package dtprogrammer.github.io.p395;

/**
 * 395. Longest Substring with At Least K Repeating Characters
 */
public class Solution {
    public int longestSubstring(String s, int k) {
        int maxWindowLength = 0;
        for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++) {
            maxWindowLength = Math.max(maxWindowLength, longestSubstring(s, k, numUniqueTarget));
        }
        return maxWindowLength;
    }

    public int longestSubstring(String s, int k, int numUniqueTarget) {
        char[] occurrences = new char[256];
        int start = 0, end = 0, maxWindowLength = 0, numUnique = 0, numNoLessThanK = 0;
        while (end < s.length()) {
            if (occurrences[s.charAt(end)]++ == 0) {
                numUnique++;
            }
            if (occurrences[s.charAt(end++)] == k) {
                numNoLessThanK++;
            }
            while (numUnique > numUniqueTarget) {
                if (occurrences[s.charAt(start)]-- == k) {
                    numNoLessThanK--;
                }
                if (occurrences[s.charAt(start++)] == 0) {
                    numUnique--;
                }
            }
            if (numUnique == numUniqueTarget && numNoLessThanK == numUniqueTarget) {
                maxWindowLength = Math.max(maxWindowLength, end - start);
            }
        }
        return maxWindowLength;
    }
}
