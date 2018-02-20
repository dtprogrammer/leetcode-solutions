package dtprogrammer.github.io.p269;

import java.util.*;

/**
 * 269. Alien Dictionary
 */
public class Solution {
    public String alienOrder(String[] words) {
        // since the questions says we can assume chars are in lowercase
        Set<Character>[] charsComesAfterTheKey = new HashSet[26];
        for (int i = 0; i < 26; i++) {
            charsComesAfterTheKey[i] = new HashSet<>();
        }
        int inDegree[] = new int[26];
        Arrays.fill(inDegree, -1);
        for(String s: words){
            for(char c: s.toCharArray()){
                inDegree[c - 'a'] = 0;
            }
        }

        // build the graph
        for (int i = 0; i < words.length - 1; i++) {

            char[] currentWord = words[i].toCharArray();
            char[] nextWord = words[i + 1].toCharArray();

            int smallerWordLength = Math.min(currentWord.length, nextWord.length);
            for (int j = 0; j < smallerWordLength; j++) {
                // if the characters are not equal then the current word character
                // comes before next word character
                if (currentWord[j] != nextWord[j]) {
                    if (!charsComesAfterTheKey[currentWord[j] - 'a'].contains(nextWord[j])) {
                        charsComesAfterTheKey[currentWord[j] - 'a'].add(nextWord[j]);
                        inDegree[nextWord[j] - 'a']++;
                    }
                    break;
                }
            }
        }

        // topological sort
        StringBuilder builder = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        int dictCharacter = 0;
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] != -1) {
                dictCharacter++;
                if (inDegree[i] == 0) {
                    queue.add((char) (i + 97));
                }
            }
        }

        while (!queue.isEmpty()) {
            Character current = queue.remove();
            builder.append(current);
            for (Character character : charsComesAfterTheKey[current - 'a']) {
                inDegree[character - 'a']--;
                if (inDegree[character - 'a'] == 0) {
                    queue.add(character);
                }
            }
        }
        if (builder.length() != dictCharacter) return "";
        return builder.toString();
    }
}
