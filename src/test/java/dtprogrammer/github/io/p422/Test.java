package dtprogrammer.github.io.p422;

import org.junit.Assert;

import java.util.Arrays;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.validWordSquare(Arrays.asList("ball", "area", "read", "lady")));
        Assert.assertTrue(solution.validWordSquare(Arrays.asList("abcd", "bnrt", "crm", "dt")));
        Assert.assertFalse(solution.validWordSquare(Arrays.asList("ball", "asee", "let", "lep")));
        Assert.assertFalse(solution.validWordSquare(Arrays.asList("abc", "b")));
    }
}
