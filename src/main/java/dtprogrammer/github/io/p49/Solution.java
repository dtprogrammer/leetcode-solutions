package dtprogrammer.github.io.p49;

import java.util.*;

/**
 * 49. Group Anagrams
 *
 * Given an array of strings, group anagrams together.
 * <p>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * <p>
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note: All inputs will be in lower-case.
 * Time complexity
 * The time complexity is O (N * M) where N is the number of string and M is the average size of string.
 * <p>
 * Space complexity
 * The space complexity is also O (N * M)
 * Time complexity
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<CharacterCounts, List<String>> groupedAnagrams = new HashMap<>();

        for (String str : strs) {
            List<String> anagrams = new LinkedList<>();
            CharacterCounts key = new CharacterCounts(str);
            if (groupedAnagrams.containsKey(key)) {
                anagrams = groupedAnagrams.get(key);
            }
            anagrams.add(str);
            groupedAnagrams.put(key, anagrams);
        }
        return new LinkedList<>(groupedAnagrams.values());
    }

    private class CharacterCounts {
        // given all inputs will be lowercase alphabets
        private int[] counts = new int[26];

        CharacterCounts(String str) {
            Arrays.fill(this.counts, 0);
            if (str != null) {
                for (int i = 0; i < str.length(); i++) {
                    counts[str.charAt(i) - 'a'] += 1;
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CharacterCounts that = (CharacterCounts) o;
            return Arrays.equals(counts, that.counts);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(counts);
        }
    }
}
