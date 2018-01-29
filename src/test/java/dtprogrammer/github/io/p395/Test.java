package dtprogrammer.github.io.p395;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.longestSubstring("aaabb", 3));
    }
}
