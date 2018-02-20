package dtprogrammer.github.io.p444;

import java.util.*;

/**
 * 444. Sequence Reconstruction
 */
public class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        for (List<Integer> seq : seqs) {
            if (seq.size() == 1) {
                adj.putIfAbsent(seq.get(0), new HashSet<>());
                inDegree.putIfAbsent(seq.get(0), 0);
            } else {
                for (int i = 0; i < seq.size() - 1; i++) {
                    Set<Integer> currentAdj = adj.getOrDefault(seq.get(i), new HashSet<>());
                    adj.putIfAbsent(seq.get(i + 1), new HashSet<>());
                    inDegree.putIfAbsent(seq.get(i), 0);
                    if (!currentAdj.contains(seq.get(i + 1))) {
                        currentAdj.add(seq.get(i + 1));
                        inDegree.put(seq.get(i + 1), inDegree.getOrDefault(seq.get(i + 1), 0) + 1);
                    }
                    adj.put(seq.get(i), currentAdj);
                }
            }
        }


        // topological sort
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            // more than two possible subsequence
            if (queue.size() > 1) {
                return false;
            }
            int current = queue.remove();
            if (index == org.length || current != org[index++]) return false;
            for (Integer i : adj.get(current)) {
                inDegree.put(i, inDegree.get(i) - 1);
                if (inDegree.get(i) == 0) {
                    queue.add(i);
                }
            }
        }
        return index == org.length && index == adj.size();
    }
}
