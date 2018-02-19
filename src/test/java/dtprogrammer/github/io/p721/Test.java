package dtprogrammer.github.io.p721;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        List<List<String>> accounts = Arrays.asList(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"));
        List<List<String>> expected = Arrays.asList(Arrays.asList("John", "johnnybravo@mail.com"),
                Arrays.asList("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"));
        List<List<String>> result = solution.accountsMerge(accounts);
        Assert.assertEquals(3, result.size());
        Assert.assertEquals(expected, result);

    }
}
