package dtprogrammer.github.io.p88;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.validPalindrome("aba"));
        Assert.assertTrue(solution.validPalindrome("abca"));
        Assert.assertFalse(solution.validPalindrome("abc"));
    }
}
