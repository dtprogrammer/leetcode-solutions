package dtprogrammer.github.io.p20;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();

        Assert.assertTrue(solution.isValid(""));
        Assert.assertTrue(solution.isValid("(){}"));
        Assert.assertTrue(solution.isValid("[()]{}"));
        Assert.assertFalse(solution.isValid("[(]{}"));
    }
}
