package dtprogrammer.github.io.p51;

import org.junit.Assert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        List<List<String>> size4Configurations = new LinkedList<>();
        size4Configurations.add(Arrays.asList(".Q..", "...Q", "Q...", "..Q."));
        size4Configurations.add(Arrays.asList("..Q.", "Q...", "...Q", ".Q.."));

        Solution solution = new Solution();
        Assert.assertEquals(size4Configurations, solution.solveNQueens(4));
        Assert.assertEquals(92, solution.solveNQueens(8).size());
    }
}
