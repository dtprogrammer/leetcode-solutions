package dtprogrammer.github.io.p150;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(9, solution.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        Assert.assertEquals(6, solution.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
