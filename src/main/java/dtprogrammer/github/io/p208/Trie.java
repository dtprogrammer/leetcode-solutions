package dtprogrammer.github.io.p208;

public class Trie {

    private Node root;

    private class Node {
        private char ch;
        private Node left, mid, right;
        private boolean terminal;

    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            throw new IllegalArgumentException();
        }
        root = insert(root, word, 0);
    }

    private Node insert(Node x, String word, int i) {
        char c = word.charAt(i);
        if (x == null) {
            x = new Node();
            x.ch = c;

        }
        if (c < x.ch) x.left = insert(x.left, word, i);
        else if (c > x.ch) x.right = insert(x.right, word, i);
        else if (i < word.length() - 1) x.mid = insert(x.mid, word, i + 1);
        else x.terminal = true;
        return x;
    }

    private Node get(Node root, String word, int i) {
        if (root == null) return null;
        char c = word.charAt(i);
        if (c < root.ch) return get(root.left, word, i);
        else if (c > root.ch) return get(root.right, word, i);
        else if (i < word.length() - 1) return get(root.mid, word, i + 1);
        else return root;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            throw new IllegalArgumentException();
        }
        Node node = get(root, word, 0);
        return node != null && node.terminal;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return get(root, prefix, 0) != null;
    }
}


