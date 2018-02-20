package dtprogrammer.github.io.p444;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Collections;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.sequenceReconstruction(new int[]{1, 2, 3},
                Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 3))));
        Assert.assertFalse(solution.sequenceReconstruction(new int[]{1, 2, 3},
                Collections.singletonList(Arrays.asList(1, 2))));
        Assert.assertTrue(solution.sequenceReconstruction(new int[]{1, 2, 3},
                Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 3), Arrays.asList(2, 3))));
        Assert.assertTrue(solution.sequenceReconstruction(new int[]{4, 1, 5, 2, 6, 3},
                Arrays.asList(Arrays.asList(5, 2, 6, 3), Arrays.asList(4, 1, 5, 2))));

    }
}
