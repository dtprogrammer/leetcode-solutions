package dtprogrammer.github.io.p159;

/**
 * 159. Longest Substring with At Most Two Distinct Characters
 */
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] occurences = new char[256];
        int start = 0, end = 0, maxWindowLength = 0, counter = 0;

        while (end < s.length()) {
            if (occurences[s.charAt(end++)]++ == 0) {
                counter++;
            }
            while (counter > 2) {
                if (occurences[s.charAt(start++)]-- == 1) {
                    counter--;
                }
            }
            maxWindowLength = Math.max(maxWindowLength, end - start);
        }
        return maxWindowLength;
    }
}
