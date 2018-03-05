package dtprogrammer.github.io.p211;

import java.util.HashMap;
import java.util.Map;

/**
 * 211. Add and Search Word - Data structure design
 */
public class WordDictionary {
    Node root;


    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        this.root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = Character.toLowerCase(word.charAt(i));
            Node child = current.children.get(cur);
            if (child == null) {
                child = new Node();
                current.children.put(cur, child);
            }
            current = child;
        }
        current.endsHere = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(word, root, 0);
    }

    public boolean search(String word, Node currentNode, int pos) {
        if (pos == word.length()) {
            return currentNode.endsHere;
        }
        char cur = Character.toLowerCase(word.charAt(pos));
        if (cur == '.') {
            for (Node child : currentNode.children.values()) {
                boolean result = search(word, child, pos + 1);
                if (result) return true;
            }
        } else {
            Node child = currentNode.children.get(cur);
            return child != null && search(word, child, pos + 1);
        }
        return false;
    }

    private class Node {
        Map<Character, Node> children;
        boolean endsHere;

        public Node() {
            this.children = new HashMap<>();
            this.endsHere = false;
        }
    }
}
