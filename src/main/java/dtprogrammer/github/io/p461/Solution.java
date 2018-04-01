package dtprogrammer.github.io.p461;

/**
 * 461. Hamming Distance
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount((x ^ y));
    }
}
