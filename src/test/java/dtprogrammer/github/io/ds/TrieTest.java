package dtprogrammer.github.io.ds;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TrieTest {

    @org.junit.Test
    public void test() throws Exception {
        Trie<Integer> st = new Trie<>();
        List<String> strings = Arrays.asList("shore",
                "shoreline", "sew", "notify", "notion",
                "sewage", "paunch",
                "paunchy",
                "shortage", "shell", "shellsorting", "sheldon",
                "shelter", "ahello", "aheelo", "ahlllo");
        for (int i = 0; i < strings.size(); i++) {
            String key = strings.get(i);
            st.put(key, i);
        }

        Assert.assertEquals("shell", st.longestPrefixOf("shell"));

        Iterator<String> shor = st.keysWithPrefix("shor").iterator();
        Assert.assertEquals("shore", shor.next());
        Assert.assertEquals("shoreline", shor.next());
        Assert.assertEquals("shortage", shor.next());
        Assert.assertFalse( shor.hasNext());

        Iterator<String> strings1 = st.keysThatMatch(".he.l.").iterator();
        Assert.assertEquals("aheelo", strings1.next());
        Assert.assertEquals("ahello", strings1.next());
        Assert.assertFalse( strings1.hasNext());

        Iterator<String> shellsorting = st.keysThatMatch("shellsorting").iterator();
        Assert.assertEquals("shellsorting", shellsorting.next());
        Assert.assertFalse( strings1.hasNext());
    }
}
