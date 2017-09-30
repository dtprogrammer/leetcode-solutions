package dtprogrammer.github.io.p242;

/**
 * 242. Valid Anagram
 * http://dtprogrammer.github.io/242-valid-anagram/
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return (s == null && t == null);
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] charCounts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            charCounts[t.charAt(i) - 'a']--;
            if (charCounts[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
