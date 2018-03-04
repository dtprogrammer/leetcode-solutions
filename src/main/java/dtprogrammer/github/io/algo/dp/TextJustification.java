package dtprogrammer.github.io.algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        if (words == null || maxWidth == 0) {
            return result;
        }

        int[][] badnessCost = new int[words.length][words.length];
        for (int[] ints : badnessCost) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        // populate the badness cost table
        for (int i = 0; i < words.length; i++) {
            badnessCost[i][i] = maxWidth - words[i].length();
            for (int j = i + 1; j < words.length; j++) {
                badnessCost[i][j] = badnessCost[i][j - 1] - words[j].length() - 1;
            }
        }

        // cube all the badness cost to penalize more white spaces severly
        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                if (badnessCost[i][j] < 0) {
                    badnessCost[i][j] = Integer.MAX_VALUE;
                } else {
                    badnessCost[i][j] = (int) Math.pow(badnessCost[i][j], 3);
                }
            }
        }

        int[] minBadnessCost = new int[words.length];
        int[] wordsInLine = new int[words.length];

        for (int i = words.length - 1; i >= 0; i--) {
            minBadnessCost[i] = badnessCost[i][words.length - 1];
            wordsInLine[i] = words.length;
            for (int j = words.length - 1; j > i; j--) {
                if (badnessCost[i][j - 1] == Integer.MAX_VALUE) {
                    continue;
                }
                if (minBadnessCost[i] > badnessCost[i][j - 1] + minBadnessCost[j]) {
                    minBadnessCost[i] = badnessCost[i][j - 1] + minBadnessCost[j];
                    wordsInLine[i] = j;
                }
            }
        }

        int i = 0;
        while (i < words.length) {
            StringBuilder builder = new StringBuilder();
            int j = i;
            for (; j < wordsInLine[i]; j++) {
                builder.append(words[j]);
                if (j != wordsInLine[i] - 1) {
                    builder.append(" ");
                }
            }
            result.add(builder.toString());
            i = j;
        }
        return result;
    }
}
