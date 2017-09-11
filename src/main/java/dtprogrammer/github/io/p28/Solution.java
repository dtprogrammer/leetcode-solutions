package dtprogrammer.github.io.p28;

/**
 * 28. Implement strStr()
 * <p>
 * Implement strStr().
 * <p>
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Time complexity: O (n * m)
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) { // haystack
            for (int j = 0; ; j++) { // needle
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}
