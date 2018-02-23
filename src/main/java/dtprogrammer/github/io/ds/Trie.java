package dtprogrammer.github.io.ds;


import java.util.LinkedList;
import java.util.Queue;

public class Trie<Value> {
    private int size;
    private Node<Value> root;

    class Node<Value> {
        private char ch;
        private Value val;
        private Node<Value> left, mid, right;
    }

    public Trie() {
    }

    public int getSize() {
        return size;
    }

    /**
     * Does this symbol table contain the given key?
     *
     * @param key the key
     * @return {@code true} if this symbol table contains {@code key} and
     * {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(String key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        return get(key) != null;
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param key the key
     * @return the value associated with the given key if the key is in the symbol table
     * and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(String key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        Node<Value> node = get(root, key, 0);
        return node == null ? null : node.val;
    }

    private Node<Value> get(Node<Value> root, String key, int i) {
        if (root == null) return null;
        if (key.length() == 0) throw new IllegalArgumentException();
        char c = key.charAt(i);
        if (c < root.ch) return get(root.left, key, i);
        else if (c > root.ch) return get(root.right, key, i);
        else if (i < key.length() - 1) return get(root.mid, key, i + 1);
        else return root;
    }

    /**
     * Inserts the key-value pair into the symbol table, overwriting the old value
     * with the new value if the key is already in the symbol table.
     * If the value is {@code null}, this effectively deletes the key from the symbol table.
     *
     * @param key the key
     * @param val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(String key, Value val) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (!contains(key)) size++;
        root = put(root, key, val, 0);
    }

    private Node<Value> put(Node<Value> root, String key, Value val, int i) {
        char c = key.charAt(i);
        if (root == null) {
            root = new Node<>();
            root.ch = c;
        }
        if (c < root.ch) root.left = put(root.left, key, val, i);
        else if (c > root.ch) root.right = put(root.right, key, val, i);
        else if (i < key.length() - 1) root.mid = put(root.mid, key, val, i + 1);
        else root.val = val;
        return root;
    }


    /**
     * Returns the string in the symbol table that is the longest prefix of {@code query},
     * or {@code null}, if no such string.
     *
     * @param query the query string
     * @return the string in the symbol table that is the longest prefix of {@code query},
     * or {@code null} if no such string
     * @throws IllegalArgumentException if {@code query} is {@code null}
     */
    public String longestPrefixOf(String query) {
        if (query == null) {
            throw new IllegalArgumentException();
        }
        if (query.length() == 0) {
            return null;
        }

        int length = 0;
        Node<Value> x = root;
        int i = 0;
        while (x != null && i < query.length()) {
            char ch = query.charAt(i);
            if (ch < x.ch) x = x.left;
            else if (ch > x.ch) x = x.right;
            else {
                i++;
                if (x.val != null) length = i;
                x = x.mid;
            }
        }
        return query.substring(0, length);
    }

    /**
     * Returns all keys in the symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in the symbol table as an {@code Iterable}
     */
    public Iterable<String> keys() {
        Queue<String> keys = new LinkedList<>();
        collect(root, new StringBuilder(), keys);
        return keys;
    }

    /**
     * Returns all of the keys in the set that start with {@code prefix}.
     *
     * @param prefix the prefix
     * @return all of the keys in the set that start with {@code prefix},
     * as an iterable
     * @throws IllegalArgumentException if {@code prefix} is {@code null}
     */
    public Iterable<String> keysWithPrefix(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("calls keysWithPrefix() with null argument");
        }
        Queue<String> queue = new LinkedList<>();
        Node<Value> x = get(root, prefix, 0);
        if (x == null) return queue;
        if (x.val != null) queue.add(prefix);
        collect(x.mid, new StringBuilder(prefix), queue);
        return queue;
    }

    private void collect(Node<Value> root, StringBuilder prefix, Queue<String> keys) {
        if (root == null) return;
        collect(root.left, prefix, keys);
        if (root.val != null) keys.add(prefix.toString() + root.ch);
        collect(root.mid, prefix.append(root.ch), keys);
        prefix.deleteCharAt(prefix.length() - 1);
        collect(root.right, prefix, keys);
    }


    /**
     * Returns all of the keys in the symbol table that match {@code pattern},
     * where . symbol is treated as a wildcard character.
     *
     * @param pattern the pattern
     * @return all of the keys in the symbol table that match {@code pattern},
     * as an iterable, where . is treated as a wildcard character.
     */
    public Iterable<String> keysThatMatch(String pattern) {
        Queue<String> queue = new LinkedList<String>();
        collect(root, pattern, 0, queue, new StringBuilder());
        return queue;
    }

    private void collect(Node<Value> root, String pattern, int pos, Queue<String> queue, StringBuilder builder) {
        if (root == null) return;
        char c = pattern.charAt(pos);
        if (c == '.' || c < root.ch) collect(root.left, pattern, pos, queue, builder);
        if (c == '.' || c == root.ch) {
            if (pos == pattern.length() - 1 && root.val != null) {
                queue.add(builder.toString() + root.ch);
            }
            if (pos < pattern.length() - 1) {
                collect(root.mid, pattern, pos + 1, queue, builder.append(root.ch));
                builder.deleteCharAt(builder.length() - 1);
            }

        }
        if (c == '.' || c > root.ch) collect(root.right, pattern, pos, queue, builder);
    }
}

