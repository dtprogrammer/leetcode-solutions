package dtprogrammer.github.io.p3;

/**
 * 3. Longest Substring Without Repeating Characters
 * Using template from: https://leetcode.com/problems/minimum-window-substring/discuss/26808
 */
public class SolutionFromTemplate {
    public int lengthOfLongestSubstring(String s) {
        char[] occurrences = new char[256];
        int begin = 0, end = 0, counter = 0, maxWindowLength = 0;

        while (end < s.length()) {
            // if first occurrence then increment the counter
            if (occurrences[s.charAt(end++)]++ > 0) {
                counter++;
            }
            while (counter > 0) {
                if (occurrences[s.charAt(begin++)]-- > 1) {
                    counter--;
                }
            }
            maxWindowLength = Math.max(maxWindowLength, end - begin);
        }
        return maxWindowLength;
    }
}
