package dtprogrammer.github.io.p38;

/**
 * 38. Count and Say
 * <p>
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: "1"
 * Example 2:
 * <p>
 * Input: 4
 * Output: "1211"
 * <p>
 * Time complexity: Each number can generate the next number which can have as much as O(2 pow n) numbers. So the
 * time complexity is O(n * 2 pow n)
 */
public class Solution {

    public String countAndSay(int n) {
        if (n < 1) {
            return "";
        }
        // init the first number in sequence
        String cur = "1";
        int curCount = 1;
        // till we reach the required number in the seq
        while (curCount != n) {
            StringBuilder builder = new StringBuilder();
            // start processing the current sequence value to generate the next one
            for (int i = 0; i < cur.length(); i++) {
                int count = 1;
                while (i + 1 < cur.length() && cur.charAt(i) == cur.charAt(i + 1)) {
                    i++;
                    count++;
                }
                builder.append(count);
                builder.append(cur.charAt(i));
            }
            // make the next sequence val current
            cur = builder.toString();
            curCount++;
        }
        return cur;
    }
}
