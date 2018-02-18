package dtprogrammer.github.io.p734;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 734. Sentence Similarity
 */
public class Solution {

    private Map<String, Set<String>> pairsDict;

    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        processPairs(pairs);

        if (words1 == null || words2 == null || words1.length != words2.length) {
            return false;
        }

        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equalsIgnoreCase(words2[i])) {
                continue;
            }
            if (!pairsDict.containsKey(words1[i]) && !pairsDict.containsKey(words2[i])) {
                continue;
            } else if (pairsDict.containsKey(words1[i]) && pairsDict.containsKey(words2[i])) {
                if (pairsDict.get(words1[i]).contains(words2[i]) && pairsDict.get(words2[i]).contains(words1[i])) {
                    continue;
                }
            }
            return false;
        }
        return true;
    }

    private void processPairs(String[][] pairs) {
        pairsDict = new HashMap<>();
        for (String[] pair : pairs) {
            processPairs(pair[0], pair[1]);
            processPairs(pair[1], pair[0]);
        }
    }

    private void processPairs(String key, String value) {
        Set<String> values = pairsDict.getOrDefault(key, new HashSet<>());
        values.add(value);
        pairsDict.put(key, values);
    }
}
