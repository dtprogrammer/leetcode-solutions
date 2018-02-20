package dtprogrammer.github.io.p269;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() {
        Solution solution = new Solution();
        Assert.assertEquals("wertf", solution.alienOrder(new String[]{"wrt",
                "wrf",
                "er",
                "ett",
                "rftt"}));

    }

}
