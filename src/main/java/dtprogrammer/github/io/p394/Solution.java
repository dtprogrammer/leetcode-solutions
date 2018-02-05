package dtprogrammer.github.io.p394;

/**
 * 394. Decode String
 * Given an encoded string, return it's decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
 * exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * <p>
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
 * repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * <p>
 * Examples:
 * <p>
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * <p>
 * Time complexity: O(n)
 */
public class Solution {
    public String decodeString(String s) {
        int[] index = new int[1];
        return decodeString(s, index);
    }

    public String decodeString(String s, int[] index) {
        StringBuilder builder = new StringBuilder();
        while (index[0] < s.length()) {
            if (Character.isDigit(s.charAt(index[0]))) {
                int repetitions = 0;
                while (Character.isDigit(s.charAt(index[0]))) {
                    repetitions = repetitions * 10 + s.charAt(index[0]++) - '0';
                }
                index[0]++; // skip [
                String inner = decodeString(s, index);
                while (repetitions > 0) {
                    builder.append(inner);
                    repetitions--;
                }
            } else if (Character.isLetter(s.charAt(index[0]))) {
                builder.append(s.charAt(index[0]++));
            } else if (s.charAt(index[0]) == ']') {
                index[0]++;
                return builder.toString();
            }
        }
        return builder.toString();
    }
}
