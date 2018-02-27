package dtprogrammer.github.io.p418;

/**
 * 418. Sentence Screen Fitting
 */
public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if (sentence == null || sentence.length == 0 || rows <= 0 || cols <= 0) {
            return 0;
        }

        StringBuilder builder = new StringBuilder();
        for (String s : sentence) {
            builder.append(s);
            builder.append(" ");
        }
        String sent = builder.toString();
        int sentenceLength = sent.length();
        int start = 0;

        for (int i = 0; i < rows; i++) {
            start += cols;
            if (sent.charAt(start % sentenceLength) == ' ') {
                start++;
            } else {
                while (start > 0 && sent.charAt((start - 1) % sentenceLength) != ' ') {
                    start--;
                }
            }
        }
        return start / sentenceLength;
    }
}
