package dtprogrammer.github.io.p347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 347. Top K Frequent Elements
 * http://dtprogrammer.github.io/347-top-k-frequent-elements/
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // create a hashmap of occurrence counts.
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }

        List<Integer> kMostOccuring = new ArrayList<>();
        int curSize = 0;
        for (int i = bucket.length - 1; i >= 0 && curSize < k; i--) {
            if (bucket[i] != null) {
                kMostOccuring.addAll(bucket[i]);
                curSize++;
            }
        }

        return kMostOccuring.subList(0, k);
    }
}
