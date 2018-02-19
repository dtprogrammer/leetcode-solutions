package dtprogrammer.github.io.p737;

import java.util.HashMap;
import java.util.Map;

/**
 * 737. Sentence Similarity II
 */
public class Solution {

    class UF {

        class Node {
            String data;
            int rank;
            Node parent;

            public Node(String data) {
                this.data = data;
                this.rank = 0;
                this.parent = this;
            }
        }

        Map<String, Node> wordDict;

        public UF() {
            wordDict = new HashMap<>();
        }

        public void makeSet(String data) {
            wordDict.put(data, new Node(data));
        }

        public boolean exists(String data) {
            return wordDict.containsKey(data);
        }

        public String findSet(String data) {
            if (exists(data)) {
                return findSet(wordDict.get(data)).data;
            }
            return "";
        }

        private Node findSet(Node node) {
            while (node != node.parent) {
                node.parent = wordDict.get(node.parent.data).parent;
                node = node.parent;
            }
            return node;
        }

        public void union(String data1, String data2) {
            if (!wordDict.containsKey(data1)) {
                makeSet(data1);
            }
            if (!wordDict.containsKey(data2)) {
                makeSet(data2);
            }
            Node parent1 = findSet(wordDict.get(data1));
            Node parent2 = findSet(wordDict.get(data2));

            if (parent1 == parent2) {
                return;
            }

            if (parent1.rank < parent2.rank) {
                parent1.parent = parent2;
            } else {
                parent2.parent = parent1;
                if (parent1.rank == parent2.rank) {
                    parent1.rank++;
                }
            }
        }
    }

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        UF uf = new UF();
        for (String[] pair : pairs) {
            uf.union(pair[0], pair[1]);
        }

        if (words1 == null || words2 == null || words1.length != words2.length) {
            return false;
        }

        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equalsIgnoreCase(words2[i])) {
                continue;
            }
            if (!uf.findSet(words1[i]).equalsIgnoreCase(uf.findSet(words2[i]))) {
                return false;
            }
        }
        return true;
    }
}
