package dtprogrammer.github.io.p66;

import java.util.Arrays;

/**
 * 66. Plus One
 * http://dtprogrammer.github.io/66-plus-one/
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                continue;
            }
            digits[i] += 1;
            carry = 0;
            break;
        }

        if (carry == 1) {
            digits = new int[digits.length + 1];
            Arrays.fill(digits, 0);
            digits[0] = 1;
        }
        return digits;
    }
}
