package dtprogrammer.github.io.p78;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    @org.junit.Test
    public void test() {
        int[] array = {1, 2, 3};
        Solution solution = new Solution();
        StackBasedSolution stackBasedSolution = new StackBasedSolution();
        List<List<Integer>> sol1 = solution.subsets(array);
        Assert.assertEquals(8, sol1.size());
        List<List<Integer>> sol2 = stackBasedSolution.subsets(array);
        Assert.assertEquals(8, sol2.size());
        verify(sol1);
        verify(sol2);
    }

    private void verify(List<List<Integer>> sol) {
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Collections.singletonList(1));
        expected.add(Collections.singletonList(2));
        expected.add(Collections.singletonList(3));
        expected.add(Arrays.asList(1, 2));
        expected.add(Arrays.asList(1, 3));
        expected.add(Arrays.asList(2, 3));
        expected.add(Arrays.asList(1, 2, 3));
        Assert.assertTrue(sol.containsAll(expected));
    }
}
