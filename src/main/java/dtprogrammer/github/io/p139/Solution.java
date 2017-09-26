package dtprogrammer.github.io.p139;

import java.util.List;

/**
 * 139. Word Break
 * http://dtprogrammer.github.io/139-word-break/
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] validPart = new boolean[s.length() + 1];

        // init
        validPart[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (validPart[j] && wordDict.contains(s.substring(j, i))) {
                    validPart[i] = true;
                    break;
                }
            }
        }
        return validPart[s.length()];
    }
}
