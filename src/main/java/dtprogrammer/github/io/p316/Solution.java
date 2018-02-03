package dtprogrammer.github.io.p316;

/**
 * 316. Remove Duplicate Letters
 * <p>
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 * <p>
 * Example:
 * Given "bcabc"
 * Return "abc"
 * <p>
 * Given "cbacdcbc"
 * Return "acdb"
 * <p>
 * Credits:
 * Special thanks to @dietpepsi for adding this problem and creating all test cases.
 * <p>
 * Time Complexity: 26 * O(n) since every call takes O(n) and at max there will be 26 recursive call because there
 * can be max 26 unique characters.
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        int smallestCharPos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(smallestCharPos)) {
                smallestCharPos = i;
            }
            if (--counts[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        return s.charAt(smallestCharPos) +
                removeDuplicateLetters(s.substring(smallestCharPos + 1).replaceAll("" +
                        s.charAt(smallestCharPos), ""));
    }
}
