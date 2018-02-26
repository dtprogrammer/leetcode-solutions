package dtprogrammer.github.io.p425;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {

    @org.junit.Test
    public void test() {
        Solution solution = new Solution();
        List<List<String>> expected = Collections.singletonList(Arrays.asList("wall", "area", "lead", "lady"));
        Assert.assertEquals(expected, solution.wordSquares(new String[]{"wall", "area", "lead", "lady"}));
    }
}
