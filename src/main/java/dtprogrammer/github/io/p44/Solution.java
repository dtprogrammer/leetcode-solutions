package dtprogrammer.github.io.p44;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 *
 * Time complexity: O(p * s)
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        int stringIndex = 0, patternIndex = 0, starMatch = 0, starIndex = -1;

        while (stringIndex < s.length()) {
            if (patternIndex < p.length() && (p.charAt(patternIndex) == s.charAt(stringIndex) ||
                    p.charAt(patternIndex) == '?')) {
                patternIndex++;
                stringIndex++;
            } else if (patternIndex < p.length() && p.charAt(patternIndex) == '*') {
                starIndex = patternIndex++;
                starMatch = stringIndex;
            } else if (starIndex != -1) {
                patternIndex = starIndex + 1;
                starMatch = starMatch + 1;
                stringIndex = starMatch;
            } else {
                return false;
            }
        }

        // its possible that pattern still has something
        while (patternIndex < p.length() && p.charAt(patternIndex) == '*') {
            patternIndex++;
        }

        return patternIndex == p.length();
    }
}
