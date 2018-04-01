package dtprogrammer.github.io.p290;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) return false;
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        String[] words = str.split("\\s+");
        if (words.length != pattern.length()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (!(charToWord.getOrDefault(pattern.charAt(i), words[i]).equals(words[i]) &&
                    wordToChar.getOrDefault(words[i], pattern.charAt(i)) == pattern.charAt(i))) {
                return false;
            }
            charToWord.putIfAbsent(pattern.charAt(i), words[i]);
            wordToChar.putIfAbsent(words[i], pattern.charAt(i));
        }
        return true;
    }
}
