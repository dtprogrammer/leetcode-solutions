package dtprogrammer.github.io.ds;

import java.util.HashMap;
import java.util.Map;

public class HashTrie {
    Node root;

    class Node {
        private Map<Character, Node> links;
        private boolean endsHere;

        public Node() {
            this.links = new HashMap<>();
            this.endsHere = false;
        }
    }

    public HashTrie() {
        this.root = new Node();
    }

    /**
     * Iterative implementation of insert into trie
     */
    public void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node child = current.links.get(ch);
            if (child == null) {
                child = new Node();
                current.links.put(ch, child);
            }
            current = child;
        }
        current.endsHere = true;
    }

    /**
     * Recursive implementation of insert into trie
     */
    public void insertRecursive(String word) {
        insertRecursive(root, word, 0);
    }

    private void insertRecursive(Node root, String word, int i) {
        if (i == word.length()) {
            root.endsHere = true;
            return;
        }
        char ch = word.charAt(i);
        Node child = root.links.get(ch);
        if (child == null) {
            child = new Node();
            root.links.put(ch, child);
        }
        insertRecursive(child, word, i + 1);
    }

    /**
     * Iterative implementation of search into trie.
     */
    public boolean search(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (current.links.get(ch) == null) {
                return false;
            }
            current = current.links.get(ch);
        }
        return current.endsHere;
    }

    /**
     * Recursive implementation of search into trie.
     */
    public boolean searchRecursive(String word) {
        return searchRecursive(root, word, 0);
    }

    private boolean searchRecursive(Node root, String word, int i) {
        if (i == word.length()) {
            return root.endsHere;
        }
        char ch = word.charAt(i);
        return root.links.get(ch) != null && searchRecursive(root.links.get(ch), word, i + 1);
    }


    /**
     * Delete word from trie.
     */
    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(Node root, String word, int i) {
        if (i == word.length()) {
            //when end of word is reached only delete if currrent.endOfWord is true.
            if (!root.endsHere) {
                return false;
            }
            root.endsHere = false;
            //if current has no other mapping then return true
            return root.links.size() == 0;
        }
        char ch = word.charAt(i);
        Node node = root.links.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, i + 1);
        if (shouldDeleteCurrentNode) {
            root.links.remove(ch);
            //return true if no mappings are left in the map.
            return root.links.size() == 0;
        }
        return false;
    }

}
