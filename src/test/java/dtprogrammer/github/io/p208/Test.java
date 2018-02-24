package dtprogrammer.github.io.p208;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Trie trie = new Trie();
        trie.insert("shore");
        trie.insert("shoreline");
        trie.insert("sew");
        trie.insert("notify");
        trie.insert("notion");
        trie.insert("paunch");
        trie.insert("shortage");
        trie.insert("shell");
        trie.insert("ahello");
        trie.insert("aheelo");
        trie.insert("ahlllo");
        Assert.assertTrue(trie.search("shortage"));
        Assert.assertFalse(trie.search("shortge"));
        Assert.assertTrue(trie.search("notify"));
        Assert.assertTrue(trie.startsWith("she"));
        Assert.assertTrue(trie.startsWith("aheelo"));
        Assert.assertFalse(trie.startsWith("xman"));
    }

}
