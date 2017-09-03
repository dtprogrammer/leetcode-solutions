package dtprogrammer.github.io.p5;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example:
 * <p>
 * Input: "babad"
 * <p>
 * Output: "bab"
 * <p>
 * Note: "aba" is also a valid answer.
 * Example:
 * <p>
 * Input: "cbbd"
 * <p>
 * Output: "bb"
 * <p>
 * Time complexity: O(n2)
 * Space complexity: O(1)
 */
public class Solution {
    public String longestPalindrome(String s) {

        if (s == null || s.isEmpty() || s.length() == 1) {
            return s;
        }

        int largestWindowsStart = 0;
        int largestWindowEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(expandAroundCenter(s, i, i), expandAroundCenter(s, i, i + 1));
            if (len > largestWindowEnd - largestWindowsStart) {
                largestWindowsStart = i - (len - 1) / 2;
                largestWindowEnd = i + len / 2;
            }

        }
        return s.substring(largestWindowsStart, largestWindowEnd + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // -1 since the right and left has moved to character which does not match or is not valid
        return right - left - 1;
    }
}
