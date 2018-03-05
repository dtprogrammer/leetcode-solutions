package dtprogrammer.github.io.p88;

/**
 * 680. Valid Palindrome II
 */
public class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        while (head <= tail) {
            if (s.charAt(head) == s.charAt(tail)) {
                head++;
                tail--;
            } else {
                return isPalindrome(s, head + 1, tail) || isPalindrome(s, head, tail - 1);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int head, int tail) {
        while (head <= tail) {
            if (Character.toLowerCase(s.charAt(head)) != Character.toLowerCase(s.charAt(tail))) {
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }
}
