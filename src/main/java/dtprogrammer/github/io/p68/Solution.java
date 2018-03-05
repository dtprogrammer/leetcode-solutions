package dtprogrammer.github.io.p68;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. Text Justification
 * Solution by greedy approach
 */
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0 || maxWidth < 0) {
            result.add(""); // leetcode expect to return a list of empty string
            return result;
        }

        int i = 0;
        while (i < words.length) {
            int j = i;
            int curLineLen = -1;
            // current line length is only increased if the next word fits
            while (j < words.length && curLineLen + words[j].length() + 1 <= maxWidth) {
                curLineLen += words[j].length() + 1;
                j++;
            }
            int evenlyDistributedSpace = 1; // at least 1 space
            int extraSpace = 0;
            int numOfSlots = j - i - 1;

            // if there is not only word in the line or if this is the last line then we don't
            // need to distribute spaces in justified manner just left alignment is needed
            if (j != i + 1 && j != words.length) {
                evenlyDistributedSpace += (maxWidth - curLineLen) / numOfSlots;
                extraSpace = (maxWidth - curLineLen) % numOfSlots;
            }

            StringBuilder builder = new StringBuilder(words[i]);
            int k = i + 1;
            while (k < j) {
                appendSpaces(builder, evenlyDistributedSpace);
                if (extraSpace > 0) {
                    appendSpaces(builder, 1);
                    extraSpace--;
                }
                builder.append(words[k]);
                k++;
            }
            int remainingSpace = maxWidth - builder.length();
            appendSpaces(builder, remainingSpace);
            result.add(builder.toString());
            i = j;
        }
        return result;
    }

    private void appendSpaces(StringBuilder builder, int evenlyDistributedSpace) {
        while (evenlyDistributedSpace > 0) {
            builder.append(" ");
            evenlyDistributedSpace--;
        }
    }
}
