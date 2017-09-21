package dtprogrammer.github.io.p39;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class Test {

    @org.junit.Test
    public void test() {
        Solution solution = new Solution();
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(2, 2, 3), Arrays.asList(7));
        Assert.assertEquals(expected, solution.combinationSum(candidates, 7));
    }
}
