package dtprogrammer.github.io.p68;

import org.junit.Assert;

import java.util.Arrays;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(Arrays.asList(""),
                solution.fullJustify(new String[]{""}, 0));
        Assert.assertEquals(Arrays.asList("This    is    an", "example  of text", "justification.  "),
                solution.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));

        Assert.assertEquals(Arrays.asList("What must be", "shall be.   "),
                solution.fullJustify(new String[]{"What", "must", "be", "shall", "be."}, 12));
    }
}
