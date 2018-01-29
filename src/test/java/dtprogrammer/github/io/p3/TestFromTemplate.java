package dtprogrammer.github.io.p3;

import org.junit.Assert;

public class TestFromTemplate {

    @org.junit.Test
    public void test() throws Exception {
        SolutionFromTemplate solution = new SolutionFromTemplate();
        Assert.assertEquals(2, solution.lengthOfLongestSubstring("abba"));
    }
}
