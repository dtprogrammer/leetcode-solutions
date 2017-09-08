package dtprogrammer.github.io.p29;

/**
 * 29. Divide Two Integers
 * <p>
 * Divide two integers without using multiplication, division and mod operator.
 * <p>
 * If it is overflow, return MAX_INT.
 * <p>
 * Time complexity:
 */
public class Solution {

    public int divide(int divided, int divisor) {

        if (divisor == 0 || (divided == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }

        int sign = (divided < 0) ^ (divisor < 0) ? -1 : 1;


        int result = 0;
        long dividendMod = Math.abs((long) divided);
        long dvs = Math.abs((long) divisor);
        while (dividendMod >= dvs) {
            long loop = 1;
            long divisorMod = dvs;
            while (dividendMod >= (divisorMod << 1)) {
                divisorMod <<= 1;
                loop <<= 1;
            }
            dividendMod -= divisorMod;
            result += loop;
        }
        return sign == 1 ? result : -result;
    }
}
