package dtprogrammer.github.io.p340;

/**
 * 340. Longest Substring with At Most K Distinct Characters
 */
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] occurrences = new char[256];
        int start = 0, end = 0, maxWindowLength = 0, counter = 0;

        while (end < s.length()) {
            if (occurrences[s.charAt(end++)]++ == 0) {
                counter++;
            }
            while (counter > k) {
                if (occurrences[s.charAt(start++)]-- == 1) {
                    counter--;
                }
            }
            maxWindowLength = Math.max(maxWindowLength, end - start);
        }
        return maxWindowLength;
    }
}
