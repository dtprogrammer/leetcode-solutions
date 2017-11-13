package dtprogrammer.github.io.p218;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        List<int[]> actualSkyline = solution.getSkyline(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12},
                {15, 20, 10}, {19, 24, 8}});
        List<int[]> expectedSkyline = Arrays.asList(new int[]{2, 10}, new int[]{3, 15}, new int[]{7, 12},
                new int[]{12, 0}, new int[]{15, 10}, new int[]{20, 8}, new int[]{24, 0});
        Assert.assertEquals(expectedSkyline.size(), actualSkyline.size());
        for (int i = 0; i < expectedSkyline.size(); i++) {
            Assert.assertTrue(Arrays.equals(expectedSkyline.get(i), actualSkyline.get(i)));
        }
    }
}
