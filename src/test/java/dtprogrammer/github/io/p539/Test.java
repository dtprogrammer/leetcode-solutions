package dtprogrammer.github.io.p539;

import org.junit.Assert;

import java.util.Arrays;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.findMinDifference(Arrays.asList("23:59", "00:00")));
        Assert.assertEquals(60, solution.findMinDifference(Arrays.asList("01:01", "02:01")));
        Assert.assertEquals(147, solution.findMinDifference(Arrays.asList("05:31","22:08","00:35")));
    }
}
