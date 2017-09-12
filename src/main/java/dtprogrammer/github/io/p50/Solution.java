package dtprogrammer.github.io.p50;

/**
 * 50. Pow(x, n)
 * <p>
 * Implement pow(x, n).
 * Time complexity: O (log n) since we reduce n by 2 in every step
 */
public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) { // power is negative
            n = -n;
            x = 1 / x;
        }
        // this will happen when x is 0 and 1/x makes its 1/0
        if (Double.isInfinite(x)) {
            return 0;
        }

        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
