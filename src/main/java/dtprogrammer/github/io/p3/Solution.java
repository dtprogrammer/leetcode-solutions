package dtprogrammer.github.io.p3;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 * "pwke" is a subsequence and not a substring.
 * <p>
 * Time complexity: O (n) since we traverse the array once.
 * Space complexity: O (m, n) where m is the size of the character set and n is the length of the string. Here we are
 * using a HashMap because we want to move the window start (i) to the position where we saw the character earlier.
 * We can use the HashSet in which case we will be only be able to move i by 1.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> indexes = new HashMap<>();
        int max = 0;
        for (int j = 0, i = 0; j < s.length(); j++) {
            if (indexes.containsKey(s.charAt(j))) {
                // it is possible that we are seeing a character which appear much before in the window and i has
                // moved beyond it so we take the max
                i = Math.max(indexes.get(s.charAt(j)), i);
            }
            max = Math.max(max, j - i + 1);
            // j + 1 since string indexes start with 1
            indexes.put(s.charAt(j), j + 1);
        }
        return max;
    }
}
