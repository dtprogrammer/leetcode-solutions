package dtprogrammer.github.io.p290;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.wordPattern("abba", "dog cat cat dog"));
        Assert.assertFalse(solution.wordPattern("abba", "dog cat cat fish"));
        Assert.assertFalse(solution.wordPattern("aaaa", "dog cat cat dog"));
        Assert.assertFalse(solution.wordPattern("abba", "dog dog dog dog"));
    }
}
