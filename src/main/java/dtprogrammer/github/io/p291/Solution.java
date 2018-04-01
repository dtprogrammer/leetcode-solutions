package dtprogrammer.github.io.p291;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 291. Word Pattern II
 */
public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null && str == null) {
            return true;
        }
        if (pattern == null || str == null) {
            return false;
        }
        Map<Character, String> patternToStr = new HashMap<>();
        Set<String> mapped = new HashSet<>();

        return isMatch(pattern, str, 0, 0, patternToStr, mapped);
    }

    private boolean isMatch(String pattern, String str, int pIndex, int sIndex, Map<Character, String> patternToStr,
                            Set<String> mapped) {
        // base case
        if (pIndex == pattern.length() && sIndex == str.length()) {
            return true;
        }
        if (pIndex == pattern.length() | sIndex == str.length()) {
            return false;
        }

        if (patternToStr.containsKey(pattern.charAt(pIndex))) {
            String matchedString = patternToStr.get(pattern.charAt(pIndex));
            if (!str.startsWith(matchedString, sIndex)) {
                return false;
            }
            // proceed further for matching
            return isMatch(pattern, str, pIndex + 1, sIndex + matchedString.length(), patternToStr, mapped);
        } else {
            // try to match with backtracking
            for (int i = sIndex + 1; i <= str.length(); i++) {
                String part = str.substring(sIndex, i);

                // if this string has been matched to some part in pattern continue
                if (mapped.contains(part)) {
                    continue;
                }

                patternToStr.put(pattern.charAt(pIndex), part);
                mapped.add(part);

                if (isMatch(pattern, str, pIndex + 1, sIndex + part.length(), patternToStr, mapped)) {
                    return true;
                }

                // backtrack
                patternToStr.remove(pattern.charAt(pIndex));
                mapped.remove(part);
            }
        }

        return false;
    }
}
