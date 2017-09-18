package dtprogrammer.github.io.p46;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        int[] array = {1, 2, 3};
        List<List<Integer>> sol = solution.permute(array);
        Assert.assertEquals(6, sol.size());
        verify(sol);
    }

    private void verify(List<List<Integer>> sol) {
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 2, 3));
        expected.add(Arrays.asList(1, 3, 2));
        expected.add(Arrays.asList(2, 1, 3));
        expected.add(Arrays.asList(2, 3, 1));
        expected.add(Arrays.asList(3, 1, 2));
        expected.add(Arrays.asList(3, 2, 1));
        Assert.assertTrue(sol.containsAll(expected));
    }
}
