package dtprogrammer.github.io.p241;

import org.junit.Assert;

import java.util.List;

public class Test {

    @org.junit.Test
    public void test() {
        Solution solution = new Solution();
        String eq1 = "2-1-1";
        List<Integer> result = solution.diffWaysToCompute(eq1);
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(0));
        Assert.assertTrue(result.contains(2));
    }
}
