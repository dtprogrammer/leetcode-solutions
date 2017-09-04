package dtprogrammer.github.io.p8;


/**
 * 8. String to Integer (atoi)
 * <p>
 * Implement atoi to convert a string to an integer.
 * <p>
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask
 * yourself what are the possible input cases.
 * <p>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible
 * to gather all the input requirements up front.
 * <p>
 * <p>
 * Time complexity: O(n)
 */
public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int i = 0;
        int num = 0;
        // skip the white spaces
        while (str.charAt(i) == ' ') {
            i++;
        }

        // determine sign if present
        int sign = 1;
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = str.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        for (; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                if (Integer.MAX_VALUE / 10 < num || (Integer.MAX_VALUE / 10 == num && str.charAt(i) - '0' > 7)) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                num = num * 10 + (str.charAt(i) - '0');
            }
        }
        return num * sign;
    }
}
