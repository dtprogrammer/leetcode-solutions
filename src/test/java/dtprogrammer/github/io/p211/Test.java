package dtprogrammer.github.io.p211;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");
        Assert.assertFalse(dictionary.search("pad"));
        Assert.assertTrue(dictionary.search("dad"));
        Assert.assertTrue(dictionary.search("Dad"));
        Assert.assertTrue(dictionary.search(".ad"));
        Assert.assertTrue(dictionary.search("b.."));
        Assert.assertTrue(dictionary.search(".a."));
        Assert.assertFalse(dictionary.search(".c."));
        Assert.assertFalse(dictionary.search("b..."));
    }
}
