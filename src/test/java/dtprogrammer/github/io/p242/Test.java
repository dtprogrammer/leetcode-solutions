package dtprogrammer.github.io.p242;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isAnagram(null, null));
        Assert.assertTrue(solution.isAnagram("", ""));
        Assert.assertTrue(solution.isAnagram("anagram", "nagaram"));
        Assert.assertFalse(solution.isAnagram("car", "rat"));
        Assert.assertFalse(solution.isAnagram("ab", "a"));
    }
}
