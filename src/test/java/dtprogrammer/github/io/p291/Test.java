package dtprogrammer.github.io.p291;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.wordPatternMatch("abab", "redblueredblue"));
        Assert.assertTrue(solution.wordPatternMatch("aaaa", "asdasdasdasd"));
        Assert.assertFalse(solution.wordPatternMatch("aabb", "xyzabcxzyabc"));
        Assert.assertTrue(solution.wordPatternMatch("d", "e"));
    }
}
