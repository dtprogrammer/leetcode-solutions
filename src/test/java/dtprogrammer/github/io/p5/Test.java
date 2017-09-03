package dtprogrammer.github.io.p5;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();

        Assert.assertEquals("aba", solution.longestPalindrome("babad"));
        Assert.assertEquals("bb", solution.longestPalindrome("cbbd"));
        Assert.assertEquals("", solution.longestPalindrome(""));
    }
}
