package dtprogrammer.github.io.p621;

import org.junit.Assert;

public class Test2 {
    @org.junit.Test
    public void test() throws Exception {
        Solution2 solution = new Solution2();
        Assert.assertEquals(8, solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
}
