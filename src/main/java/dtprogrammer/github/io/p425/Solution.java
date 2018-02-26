package dtprogrammer.github.io.p425;

import java.util.*;

/**
 * 425. Word Squares
 */
public class Solution {
    class TrieNode {
        private Map<Character, TrieNode> children;
        private List<String> wordsStartWith;

        public TrieNode() {
            this.children = new HashMap<>();
            this.wordsStartWith = new LinkedList<>();
        }
    }

    class Trie {
        private TrieNode root;

        public Trie(String[] words) {
            root = new TrieNode();
            for (String word : words) {
                insert(word);
            }
        }

        private void insert(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TrieNode child = current.children.getOrDefault(ch, new TrieNode());
                child.wordsStartWith.add(word);
                current.children.putIfAbsent(ch, child);
                current = child;
            }
        }

        private List<String> search(String prefix) {
            List<String> result = new LinkedList<>();
            TrieNode current = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                TrieNode child = current.children.get(ch);
                if (child == null) {
                    return result;
                }
                current = child;
            }
            result.addAll(current.wordsStartWith);
            return result;
        }
    }


    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return new ArrayList<>();
        }
        Trie trie = new Trie(words);
        List<String> currentlist = new ArrayList<>();
        int sqLength = words[0].length();
        for (String word : words) {
            currentlist.add(word);
            searchSquare(trie, currentlist, sqLength, result);
            currentlist.remove(currentlist.size() - 1);
        }
        return result;
    }

    private void searchSquare(Trie trie, List<String> currentlist, int sqLength, List<List<String>> result) {
        if (currentlist.size() == sqLength) {
            result.add(new ArrayList<>(currentlist));
            return;
        }
        int prefixSize = currentlist.size();
        StringBuilder prefix = new StringBuilder();
        for (String s : currentlist) {
            prefix.append(s.charAt(prefixSize));
        }
        for (String wordWithPrefix : trie.search(prefix.toString())) {
            currentlist.add(wordWithPrefix);
            searchSquare(trie, currentlist, sqLength, result);
            currentlist.remove(currentlist.size() - 1);
        }
    }
}
