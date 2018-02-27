package dtprogrammer.github.io.p418;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.wordsTyping(new String[]{"a", "bcd", "e"}, 3, 6));
    }
}
