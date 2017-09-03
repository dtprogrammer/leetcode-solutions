package dtprogrammer.github.io.p3;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();

        Assert.assertEquals(2, solution.lengthOfLongestSubstring("abba"));
    }
}
